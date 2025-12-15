import java.util.Scanner;

public class BankAccount {
    double balance = 0;
    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Deposit method
    public double deposit(double amount) {
        if (amount <= 0) {
            ConsoleUI.negativeInput();
            return balance;
        }
        balance += amount;
        return balance;
    }
    // Withdraw method
    public double withdraw(double amount) {
        if (amount <= 0) {
            ConsoleUI.negativeInput();
            return balance;
        }
        if (amount > balance) {
            System.out.println("⚠\uFE0FInsufficient balance.");
            return balance;
        }
        balance -= amount;
        return balance;
    }
}

