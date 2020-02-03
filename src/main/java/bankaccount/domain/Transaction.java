package bankaccount.domain;

import java.math.BigDecimal;


public class Transaction {
    //contul sursa
    private final Account from;
    //contul destinatie
    private final Account to;
    //tipul tranzactiei daca este debit (incasare de la from-Account  la to-Account) sau credit (incasare de la to la from)
    private final TransactionType type;
    //suma tranzactiei
    private final BigDecimal amount;

    public Transaction(Account from, Account to, TransactionType type, BigDecimal amount) {
        if (from.getIban() == null || to.getIban() == null) {
            throw new TransactionException("Ibanul accountului nu poate fi null!!");
        }
        if (from.getIban().equals(to.getIban())) {
            throw new TransactionException("Tranzacita nu se poate executa, deoarece accountFrom=acountTo");
        }
        this.from = from;
        this.to = to;
        this.type = type;
        this.amount = amount;
    }

    public Account getFrom() {
        return from;
    }

    public Account getTo() {
        return to;
    }

    public TransactionType getType() {
        return type;
    }


    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "from=" + from +
                ", to=" + to +
                ", type=" + type +
                ", amount=" + amount +
                '}';
    }
}
