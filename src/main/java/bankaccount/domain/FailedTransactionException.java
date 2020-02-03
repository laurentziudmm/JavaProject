package bankaccount.domain;

/**
 * TransactionException
 **/

public class FailedTransactionException extends TransactionException {
    public FailedTransactionException(String message) {
        super(message);
    }
}
