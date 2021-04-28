package exam;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private final List<BankAccount> accounts = new ArrayList<>();
    private final List<Remittance> remittances = new ArrayList<>();

    public void addAccount(BankAccount bankAccount) {
        accounts.add(bankAccount);
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public BankAccount getRandomAccount() {
        return accounts.get((int) (Math.random() * accounts.size()));
    }

    public void addRemittance(Remittance remittance) {
        remittances.add(remittance);
    }

    public List<Remittance> getRemittances() {
        return remittances;
    }
}

