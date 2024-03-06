import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATMmachine {
    private BankAccount userAccount;

    public ATMmachine(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    void Atminterface() {
         Scanner scanner = new Scanner(System.in);
        System.out.println("\nATM Options:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        int option=scanner.nextInt();
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
        private void checkBalance() {
        System.out.println("Your current balance: $" + userAccount.getBalance());
    }

    private void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the deposit amount: $");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            userAccount.deposit(amount);
            System.out.println("Deposit successful. Your new balance: $" + userAccount.getBalance());
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    private void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the withdrawal amount: $");
        double amount = scanner.nextDouble();

        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Your new balance: $" + userAccount.getBalance());
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance. Withdrawal failed.");
        }
    }

    }


public class ATM {
    public static void main(String[] args) {
       

        // Set the initial balance to $25,000
        double initialBalance = 25000.0;
        BankAccount userAccount = new BankAccount(initialBalance);

        ATMmachine atm = new ATMmachine(userAccount);
     atm.Atminterface();
    }
}