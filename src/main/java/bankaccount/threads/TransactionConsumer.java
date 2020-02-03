package bankaccount.threads;

import org.apache.log4j.Logger;
import bankaccount.domain.Account;
import bankaccount.domain.Transaction;
import bankaccount.domain.TransactionException;
import bankaccount.util.Util;
import bankaccount.util.WaitingTransactions;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Transaction consumer
 **/
public class TransactionConsumer implements Runnable {
    private static AtomicInteger AT = new AtomicInteger();
    private static final Logger LOGGER = Logger.getLogger(TransactionProducer.class);

    public void run() {
        Transaction transaction = WaitingTransactions.get().next();

        if (transaction != null) {
            Account creditedAccount = Util.getCreditedAccount(transaction);
            Account debitedAccount = Util.getDebitedAccount(transaction);
            try {
                Util.debit(debitedAccount, transaction.getAmount());
                Util.credit(creditedAccount, transaction.getAmount());

                LOGGER.debug("S-a procesat cu succes o noua tranzactie " + AT.incrementAndGet());
            } catch (TransactionException e) {
                try {
                    LOGGER.debug("A picat o noua tranzactie " + transaction);
                    Thread.sleep(1);
                    WaitingTransactions.get().addFailedTransaction(transaction);
                } catch (InterruptedException e1) {
                    LOGGER.error(e1);
                }
            }
        }
    }
}
