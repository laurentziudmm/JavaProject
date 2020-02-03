package bankaccount.domain;

/**
 * TransactionException
 **/

public class TransactionException extends RuntimeException {
    public TransactionException(String message) {
        super(message);
    }
}
