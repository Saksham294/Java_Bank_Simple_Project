import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService bank = new BankService();

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
                case 1 -> {
                    System.out.print("Account number: ");
                    String acc = sc.nextLine();
                    System.out.print("Holder name: ");
                    String name = sc.nextLine();
                    bank.createAccount(acc, name);
                }
                case 2 -> {
                    System.out.print("Account number: ");
                    String acc = sc.nextLine();
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    bank.deposit(acc, amt);
                }
                case 3 -> {
                    System.out.print("Account number: ");
                    String acc = sc.nextLine();
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    bank.withdraw(acc, amt);
                }
                case 4 -> {
                    System.out.print("Account number: ");
                    String acc = sc.nextLine();
                    bank.checkBalance(acc);
                }
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
