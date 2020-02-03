package bankaccount.util;

import bankaccount.domain.Transaction;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Waiting transaction to be consumed. Aceasta clasa este un Singleton
 **/

public enum WaitingTransactions {
    //Singleton
    INSTANCE;
    //numarul maxim de tranzactii in asteptare
    private static final int MAX = 1000;

    //coada in care tranzactiile vor putea fi adaugate spre a fi procesate. Este de tip concurenta spre a fi thread safe
    private ConcurrentLinkedQueue<Transaction> pool = new ConcurrentLinkedQueue<Transaction>();

    /**
     * Metoda va intoarce singura instanta a acestei clase (INSTANCE)
     * @return INSTANCE
     */
    public static WaitingTransactions get() {
        return INSTANCE;
    }

    /**
     * Se adauga o tranzactie noua, produsa de TransactionProducer
     * Tranzactia se poate adauga daca mai este loc in coada, daca dimensiunea cozii nu va depasi nr MAX
     *
     * Din cauza ca Producatorul nu mai poate adauga tranzactii (s-a depasit numarul maxim de tranzactii ce pot intra in coada)
     * se produce in deadlock, pentru ca toate thread-urile de tip consumer asteapta dupa monitorul lui pool(coada) care este al consumatorului
     * Acesta nu va lasa monitorul (release) decat dupa ce va putea adauga tranzactia in coada.
     * Pentru deblocare se foloseste notifyAll - pentru a instiinta toate threadurile care astepata dupa monitorul cozii ( proprietatea pool)
     *
     * @param transaction - o noua tranzatie produsa ce urmeaza a fi procesata
     * @return - true daca tranzactia s-a adaugat.
     */
    public boolean addNewTransaction(Transaction transaction) {
        boolean b = pool.size() < MAX;
        if (!b) {
            //pentru a iesi din deadlock
            pool.notifyAll();
            return false;
        }
        return pool.add(transaction);
    }

    /**
     * Se adauga in coada de asteptare, pe ultima pozitie, o tranzactie ce a esuat
     * Tranzactiile esuate se vor adauga indiferent de dimensiunea cozii
     *
     * @param transaction - tranzactia esuata ce urmeaza a fi readaugata in coada
     */
    public void addFailedTransaction(Transaction transaction) {
        pool.add(transaction);
    }

    /**
     * Metoda va scoata o tranzactie din coada spre a fi consumata
     * FIFO - se scoate cea mai veche tranzactie adaugata is va fi data unui consumator  spre executie
     *
     * @return - cea mai veche tranzactie
     */
    public Transaction next() {
        return pool.poll();
    }

}
