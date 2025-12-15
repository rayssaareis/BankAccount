import java.util.Scanner;

public class Main {

    public static final String SEPARATOR_LINE = "===================";

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount();
        ConsoleUI consoleUI = new ConsoleUI(scanner, account);

        boolean isRunning = true;

        while (isRunning) {
            ConsoleUI.displayMenu();

            System.out.print("Enter your choice: ");
            int selectedOption = ConsoleUI.readInt(scanner);

            switch (selectedOption) {
                case 1 -> System.out.printf(
                        "%s\nThe Balance is %.2f\n%s\n",
                        SEPARATOR_LINE,
                        account.getBalance(),
                        SEPARATOR_LINE
                );
                case 2 -> consoleUI.tryDeposit();
                case 3 -> consoleUI.tryWithdraw();
                case 4 -> {
                    System.out.println("Goodbye!");
                    isRunning = false;
                }
                default -> System.out.println("⚠️ Invalid option.");
            }
        }

        scanner.close();
    }
}


