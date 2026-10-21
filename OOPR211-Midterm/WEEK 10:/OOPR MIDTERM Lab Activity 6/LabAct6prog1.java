package com.mycompany.labact6prog1;

import java.util.Scanner;

abstract class Account {
    private double balance;
    
    public Account(double openingBalance) {
        this.balance = openingBalance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }
    
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        if (balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public abstract String getAccountType();
}

class BankAccount extends Account {
    public BankAccount(double openingBalance) {
        super(openingBalance);
    }

    @Override
    public String getAccountType() {
        return "Bank Account"; 
    }
} 
    
public class LabAct6prog1 { 
    private static final String PESO = "PHP ";
    private static final Scanner scanner = new Scanner(System.in);
    private static Account selectedAccount;
    private static BankAccount bankAccount; 

    public static void main(String[] args) {
        System.out.println("Welcome!!");
        
        double opening = readNonNegativeBalance();
        bankAccount = new BankAccount(opening);
        selectedAccount = bankAccount;
        
        boolean running = true;
        while (running) {
            System.out.println("--------------------------");
            System.out.println("Select an option");
            showMenu();
            String choice = readLine("");
            System.out.println("--------------------------");
            if (choice == null) {                
                break;
            }

            switch (choice.trim()) {
                case "1":
                    handleWithdraw();
                    break;
                case "2": 
                    handleDeposit();
                    break;
                case "3": 
                    System.out.println("Thank you for using the system");
                    running = false;
                    break;
                default: 
                    System.out.println("Invalid choice. Please enter a valid number.");
            }
        }
    }
    
    public static void showMenu() {
        System.out.println("\n1. Withdraw\n2. Deposit\n3. Exit"); 
    }
    
    public static void printAccountSummary() {
        System.out.println("Your new balance is: " + money(selectedAccount.getBalance()));
    }
    
    private static void handleWithdraw() {
        double amount = readPositiveAmount("How much amount you want to withdraw from your account?\nAmount: ");
        if (amount <= 0) {
            return;                              
        }
        if (selectedAccount.withdraw(amount)) {
            System.out.println("your new balance is: " + money(selectedAccount.getBalance()));
        } else {
            System.out.println("Insufficient funds: amount " + money(amount) + " exceeds balance " + money(selectedAccount.getBalance()));
        }
    }
    
    private static void handleDeposit() {
        double amount = readPositiveAmount("Amount to deposit: ");
        if (amount < 0) {
            return;
        }
        if (selectedAccount.deposit(amount)) {
            System.out.println("your new balance is: " + money(selectedAccount.getBalance()));
        }
    }
    
    public static double readNonNegativeBalance() {
        while (true) {
            String line = readLine("Enter your balance: ");
            if (line == null) {
                return 0;                        
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
        return PESO + String.format("%.2f", value);
    }
}
