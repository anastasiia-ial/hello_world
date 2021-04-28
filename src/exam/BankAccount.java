package exam;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount implements Account {
    private static long accountCounter = 1_000_000_000;
    Lock lock = new ReentrantLock();
    private final Storage storage;
    private final long accountNumber;
    private long amount;
    private final String accountName;

    public BankAccount(Storage storage, String accountName) {
        this.storage = storage;
        accountNumber = setAccountNumber();
        amount = (long) (Math.random() * Integer.MAX_VALUE/10);
        this.accountName = accountName;
    }

    public static long setAccountNumber() {
        return ++accountCounter;
    }

    @Override
    public void transferMoney(BankAccount to) {
        long transferAmount = (long) (Math.random() * Integer.MAX_VALUE/100);
        try {
            if (tryTwoLocks(this.lock, to.getLock())) {
                Remittance remittance = new Remittance(this, to, transferAmount);
                storage.addRemittance(remittance);
                if (transferAmount <= amount && transferAmount > 0) {
                    amount -= transferAmount;
                    to.setAmount(getAmount() + transferAmount);
                    System.out.println("Успешный перевод суммы " + transferAmount + " от " + this + " клиенту " + to);
                } else {
                    System.out.println("Не удалось перевести сумму " + transferAmount + " от " + this + " клиенту " + to);
                }
                this.lock.unlock();
                to.getLock().unlock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean tryTwoLocks(Lock first, Lock second) {
        while (true) {
            if (first.tryLock()) {
                if (second.tryLock()) {
                    return true;
                }
                first.unlock();
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getAccountName() {
        return accountName;
    }

    public Lock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "Account{" +
                "номер=" + accountNumber +
                ", имя=" + accountName + '}';
    }
}

