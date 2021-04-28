package exam;

public class Main {
    public static void main(String[] args) {
        perform(5, 3, 10);
    }

    public static void perform(int accounts, int threads, int transferOperations) {
        Storage storage = new Storage();
        createAccounts(storage, accounts);
        createSeveralThreads(storage, threads, transferOperations);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Переводы:");
        for (Remittance remittance : storage.getRemittances()) {
            System.out.println(remittance);
        }
        System.out.println();

        System.out.println("Созданные аккаунты:");
        for (BankAccount account : storage.getAccounts()) {
            System.out.println("Имя аккаунта: " + account.getAccountName() + ", остаток - " + account.getAmount());
        }
    }

    public static void createAccounts(Storage storage, int number) {
        for (int i = 0; i < number; i++) {
            BankAccount bankAccount = new BankAccount(storage, "Клиент " + (i + 1));
            storage.addAccount(bankAccount);
        }
    }

    public static void createSeveralThreads(Storage storage, int numberThreads, int numberTransfer) {
        for (int i = 0; i < numberThreads; i++) {
            createAndStartThreadAndMakeTransfers(storage, numberTransfer);
        }
    }

    public static void createAndStartThreadAndMakeTransfers(Storage storage, int number) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < number; i++) {
                BankAccount from = storage.getRandomAccount();
                BankAccount to = storage.getRandomAccount();
                from.transferMoney(to);
            }
        });
        thread.start();
    }
}
