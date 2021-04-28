package exam;

public class Remittance {
    private static long count = 0;

    private final long id;
    private final Account from;
    private final Account to;
    private final long amount;

    public Remittance(Account from, Account to, long amount) {
        id = setId();
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public static long setId() {
        return ++count;
    }

    @Override
    public String toString() {
        return "Перевод " + id + ": от кого - " + from +
                ", кому - " + to +
                ", сумма " + amount;
    }
}
