package bankaccount.threads;

import org.apache.log4j.Logger;
import bankaccount.domain.Account;
import bankaccount.domain.Transaction;
import bankaccount.util.Util;
import bankaccount.util.WaitingTransactions;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * Transaction producer
 */
public class TransactionProducer implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(TransactionProducer.class);
    private static AtomicInteger AT = new AtomicInteger();

    public void run() {

        Transaction transaction = Util.generateTransaction();

        while (!WaitingTransactions.get().addNewTransaction(transaction)) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                LOGGER.error(e);
            }
        }


        Account account2 = Util.getCreditedAccount(transaction);
        Account account1 = Util.getDebitedAccount(transaction);

        int i = AT.incrementAndGet();
        LOGGER.debug("O noua tranzactie(" + i + ") pusa la procesare in valoare de " + transaction.getAmount()
                + " de la " + account1 + " la " + account2);
    }
}
