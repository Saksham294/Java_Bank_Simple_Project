import java.util.*;

class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = 0.0;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
        else System.out.println("Invalid amount!");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
        }
    }
}

public class BankSystem {
    private static Map<String, BankAccount> accounts = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Simple Bank System ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> checkBalance();
                case 5 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter account number: ");
        String acc = sc.nextLine();

        if (accounts.containsKey(acc)) {
            System.out.println("Account already exists!");
            return;
        }

        System.out.print("Enter holder name: ");
        String name = sc.nextLine();

        accounts.put(acc, new BankAccount(acc, name));
        System.out.println("Account created successfully!");
    }

    private static void deposit() {
        System.out.print("Enter account number: ");
        String acc = sc.nextLine();

        BankAccount account = accounts.get(acc);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter amount: ");
        double amt = sc.nextDouble();
        account.deposit(amt);
        System.out.println("Deposit successful!");
    }

    private static void withdraw() {
        System.out.print("Enter account number: ");
        String acc = sc.nextLine();

        BankAccount account = accounts.get(acc);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter amount: ");
        double amt = sc.nextDouble();
        account.withdraw(amt);
        System.out.println("Withdrawal attempt finished!");
    }

    private static void checkBalance() {
        System.out.print("Enter account number: ");
        String acc = sc.nextLine();

        BankAccount account = accounts.get(acc);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.println("Balance: ₹" + account.getBalance());
    }
}
