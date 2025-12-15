import java.util.Scanner;

public class ConsoleUI {
    private BankAccount account;
    private Scanner scanner;
    public ConsoleUI(Scanner scanner, BankAccount account) {
        this.scanner = scanner;
        this.account = account;
    }
    // Displays the menu
    public static void displayMenu() {
        System.out.println("""
            === BANK ACCOUNT MENU ===
            1 - Show Balance
            2 - Deposit
            3 - Withdraw
            4 - Exit <3""");
    }
    // Reads an integer from the scanner with input validation
    public static int readInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                ConsoleUI.invalidInput();
            }
        }
    }
    // Reads a double from the scanner with input validation
    public static double readDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                ConsoleUI.invalidInput();
            }
        }
    }
    // Attempt to deposit money
    public void tryDeposit() {
        System.out.print("Enter the amount to be Deposit: ");
        double amount = readDouble(scanner);
        processTransaction(amount, "Deposit");
    }
    // Attempt to withdraw money
    public void tryWithdraw() {
        System.out.print("Enter the amount to be withdraw: ");
        double amount = readDouble(scanner);
        processTransaction(amount, "Withdraw");
    }
    // Process the transfer and display results
    public void processTransaction(double amount, String method) {
        double oldBalance = account.getBalance();
        double newBalance;

        if (method.equalsIgnoreCase("Deposit")) {
            newBalance = account.deposit(amount);
        } else if (method.equalsIgnoreCase("Withdraw")) {
            newBalance = account.withdraw(amount);
        } else {
            System.out.println("⚠\uFE0FUnknown operation.");
            return;
        }

        if (oldBalance != newBalance) {
            System.out.printf("%s\nSUCCESS!\nOld balance: %.2f\nNew balance: %.2f\n%s\n",
                    Main.SEPARATOR_LINE, oldBalance, newBalance, Main.SEPARATOR_LINE);
        }
    }
    // Display invalids message
    public static void invalidInput() {
        displayMenu();
        System.out.print("⚠\uFE0FInvalid input.\nPlease enter a valid amount: ");
    }
    public static void negativeInput() {
        System.out.println("⚠\uFE0FThe amount cannot be negative or zero.");
    }

}
