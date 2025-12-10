import java.util.HashMap;
import java.util.Map;

public class BankService {

    private Map<String, BankAccount> accounts = new HashMap<>();

    public void createAccount(String acc, String name) {
        if (accounts.containsKey(acc)) {
            System.out.println("Account already exists!");
            return;
        }
        accounts.put(acc, new BankAccount(acc, name));
        System.out.println("Account created!");
    }

    public void deposit(String acc, double amt) {
        BankAccount account = accounts.get(acc);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        account.deposit(amt);
        System.out.println("Deposit successful!");
    }

    public void withdraw(String acc, double amt) {
        BankAccount account = accounts.get(acc);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        account.withdraw(amt);
    }

    public void checkBalance(String acc) {
        BankAccount account = accounts.get(acc);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.println("Balance: ₹" + account.getBalance());
    }
}
