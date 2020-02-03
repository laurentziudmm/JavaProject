package bankaccount.util;

import bankaccount.domain.Account;
import bankaccount.domain.Transaction;
import bankaccount.domain.TransactionException;
import bankaccount.domain.TransactionType;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Util {
    private static final int AMMOUNT_INTERVAL = 1000;
    private static final int ACCOUNT_NO = 10;
    private static Map<Integer, Account> accountMap = new HashMap<Integer, Account>();

    /**
     * Metoda va inceraca sa debiteze un cont cu o suma primita ca param
     * In cazul in care nu sunt suficienti bani in cont, metoda arunca o execptie de tip TransationException
     *
     * @param account - contul din care se debiteaza
     * @param amount  - suma de debitare
     */
    public static void debit(Account account, BigDecimal amount) {
        BigDecimal add = account.getAmount().add(amount.negate());
        if (add.compareTo(BigDecimal.ZERO) >= 0) {
            account.setAmount(add);
        } else {
            throw new TransactionException("Fonduri insuficiente pentru " + account);
        }

    }

    /**
     * Metoda va credita un cont cu o suma primita ca parametru
     *
     * @param account - contul in care se crediteaza
     * @param amount  - suma de de creditare
     */
    public static void credit(Account account, BigDecimal amount) {
        account.setAmount(account.getAmount().add(amount));
    }

    /**
     * Metoda intoarce in functie de tipul tranzactiei, contul din care se debiteaza
     *
     * @param transaction - tranzactie din care se va evalua tipul acesteia
     * @return - contul din care se debiteaza
     */
    public static Account getDebitedAccount(Transaction transaction) {
        return transaction.getType() == TransactionType.DEBIT ? transaction.getFrom() : transaction.getTo();
    }

    /**
     * Metoda intoarce in functie de tipul tranzactiei, contul in care se crediteaza
     *
     * @param transaction - tranzactie din care se va evalua tipul acesteia
     * @return - contul in care se crediteaza
     */
    public static Account getCreditedAccount(Transaction transaction) {
        return transaction.getType() == TransactionType.CREDIT ? transaction.getFrom() : transaction.getTo();
    }

    /**
     * Metoda va intoarce un cont nou/exitent in functie de un id, si o suma initiala
     *
     * @param id     - id-ul contului
     * @param amount - suma initiala a contului(in cazul in care contul se va crea)
     * @return - un cont nou sau exitent
     */
    private static Account getOrCreateAccount(Integer id, Integer amount) {
        Account ret = null;
        if (accountMap.containsKey(id)) {
            ret = accountMap.get(id);
        } else {
            ret = new Account(
                    "ro" + id, BigDecimal.valueOf(amount)
            );
            accountMap.put(id, ret);
        }
        return ret;
    }

    /**
     * Metoda va genera random o tranzactie
     *
     * @return o noua tranzactie
     */
    public static Transaction generateTransaction() {


        Random random = new Random();

        int fromAccount = random.nextInt(ACCOUNT_NO);
        int toAccount = random.nextInt(ACCOUNT_NO);
        int transactionAmmount = random.nextInt(AMMOUNT_INTERVAL) + AMMOUNT_INTERVAL / 2;
        int transactionAccountFrom = random.nextInt(AMMOUNT_INTERVAL) + AMMOUNT_INTERVAL;
        int transactionAccountTo = random.nextInt(AMMOUNT_INTERVAL) + AMMOUNT_INTERVAL;
        while (fromAccount == toAccount) {
            toAccount = random.nextInt(ACCOUNT_NO);
        }


        Account account1 = getOrCreateAccount(fromAccount, transactionAccountFrom);
        Account account2 = getOrCreateAccount(toAccount, transactionAccountTo);


        return new Transaction(
                account1, account2, TransactionType.DEBIT, BigDecimal.valueOf(transactionAmmount)
        );

    }


}
