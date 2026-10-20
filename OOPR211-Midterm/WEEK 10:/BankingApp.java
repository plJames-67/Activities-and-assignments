import java.util.Locale;
import java.util.Scanner;

abstract class Account {
    private final String accountNumber;
    private double balance;

    public Account(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    /** Adds amount to balance. Returns false (no change) if amount <= 0. */
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    /**
     * Withdraws amount plus the fee from calculateWithdrawalFee().
     */
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        double fee = calculateWithdrawalFee();   // polymorphic call
        if (amount + fee > balance) {
            return false;
        }
        balance -= (amount + fee);
        return true;
    }

    public abstract double calculateWithdrawalFee();

    public abstract String getAccountType();
}

// ---------------------------------------------------------------- SavingsAccount
class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override
    public double calculateWithdrawalFee() {
        return 0;
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}

// ---------------------------------------------------------------- CheckingAccount
class CheckingAccount extends Account {
    public CheckingAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override
    public double calculateWithdrawalFee() {
        return 10;
    }

    @Override
    public String getAccountType() {
        return "Checking";
    }
}

// ---------------------------------------------------------------- BankingApp
public class BankingApp {
    private static final String PESO = "PHP ";
    private static final Scanner scanner = new Scanner(System.in);
    private static Account selectedAccount;
    private static SavingsAccount savingsAccount;
    private static CheckingAccount checkingAccount;

    public static void main(String[] args) {
        System.out.println("Welcome to the OOP Banking System");

        double opening = readNonNegativeBalance();
        savingsAccount = new SavingsAccount("SAVING", opening);
        checkingAccount = new CheckingAccount("CHECKING", opening);
        selectedAccount = savingsAccount;        // upcast: Account refers to a SavingsAccount

        printAccountSummary();

        boolean running = true;
        while (running) {
            showMenu();
            String choice = readLine("Choice: ");
            if (choice == null) {                // input closed
                break;
            }

            switch (choice.trim()) {
                case "1"-> handleWithdraw();
                case "2"-> handleDeposit();
                case "3"-> printAccountSummary();
                case "4"->{
                    selectedAccount = (selectedAccount == savingsAccount) ? checkingAccount : savingsAccount;
                    printAccountSummary();
                }
                case "5"-> running = false;
                default-> System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }

        System.out.println("Thank you for using the system!");
    }

    // ------------------------------------------------------------ menu / display
    public static void showMenu() {
        System.out.println("1 Withdraw  2 Deposit  3 Show balance  4 Switch account  5 Exit");
    }

    public static void printAccountSummary() {
        System.out.println("Current account: " + selectedAccount.getAccountType()
                + " (" + selectedAccount.getAccountNumber() + ")"
                + " | Balance: " + money(selectedAccount.getBalance()));
    }

    // ------------------------------------------------------------ transactions
    private static void handleWithdraw() {
        double amount = readPositiveAmount("Amount to withdraw: ");
        if (amount < 0) {
            return;                              // message already shown
        }
        double fee = selectedAccount.calculateWithdrawalFee();
        if (selectedAccount.withdraw(amount)) {
            System.out.println("Withdrawal fee: " + money(fee)
                    + " | New " + selectedAccount.getAccountType()
                    + " balance: " + money(selectedAccount.getBalance()));
        } else {
            System.out.println("Insufficient funds: amount " + money(amount) + " + fee " + money(fee)
                    + " exceeds balance " + money(selectedAccount.getBalance()) + ". No fee charged.");
        }
    }

    private static void handleDeposit() {
        double amount = readPositiveAmount("Amount to deposit: ");
        if (amount < 0) {
            return;
        }
        if (selectedAccount.deposit(amount)) {
            System.out.println("New " + selectedAccount.getAccountType()
                    + " balance: " + money(selectedAccount.getBalance()));
        }
    }

    // ------------------------------------------------------------ input helpers
    /** Repeats until the user enters a number >= 0. */
    public static double readNonNegativeBalance() {
        while (true) {
            String line = readLine("Opening balance: ");
            if (line == null) {
                return 0;                        // input closed; fall back to zero
            }
            try {
                double value = Double.parseDouble(line.trim());
                if (Double.isNaN(value) || Double.isInfinite(value) || value < 0) {
                    System.out.println("Opening balance must be zero or more.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a numeric opening balance.");
            }
        }
    }

    /** Returns a positive amount, or -1 (after printing a message) if the input is invalid. */
    public static double readPositiveAmount(String prompt) {
        String line = readLine(prompt);
        if (line == null) {
            return -1;
        }
        try {
            double value = Double.parseDouble(line.trim());
            if (Double.isNaN(value) || Double.isInfinite(value) || value <= 0) {
                System.out.println("Amount must be greater than zero. Balance unchanged.");
                return -1;
            }
            return value;
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a number. Balance unchanged.");
            return -1;
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        if (!scanner.hasNextLine()) {
            System.out.println();
            return null;
        }
        return scanner.nextLine();
    }

    private static String money(double value) {
        return PESO + String.format(Locale.US, "%.2f", value);
    }
}