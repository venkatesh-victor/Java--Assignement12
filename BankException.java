import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException() {
        super("Insufficient balance.");
    }
}

// BankAccount class representing a bank account
class BankAccount {
    private String accountNumber;
    private String name;
    private double balance;

    public BankAccount(String name, String accountNumber, double initialBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException();
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Current balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNo() {
        return accountNumber;
    }
}

// Bank class representing a bank with multiple accounts
class Bank {
    private List<BankAccount> bankAccounts = new ArrayList<>();

    public void addAccount(BankAccount account) {
        bankAccounts.add(account);
    }

    public void displayAllAccounts() {
        for(BankAccount account : bankAccounts) {
            System.out.println("The account " + account.getAccountNo() + " has " + account.getBalance() + "$");
        }
    }
}

public class BankException {

    static Scanner sc = new Scanner(System.in);
    static BankAccount userAccount;
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("Do you want to set up an account?");
        System.out.println("Enter the details here."); 
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        try {
            if(name.matches("[0-9]?+")) {
                throw new InvalidInputException();
            }
        } catch(InvalidInputException e) {
            System.out.println("This is not a valid name.");
            System.out.println("Enter a valid name next time.");
            System.exit(0);
        }

        String accountNumber = String.valueOf((int) (Math.random() * 101) + 1000);
        System.out.println("Your account number is " + accountNumber);
        System.out.print("Enter an amount to deposit as an initial amount: ");
        int initialBalance = sc.nextInt();

        try {
            userAccount = new BankAccount(name, accountNumber, initialBalance);
            bank.addAccount(userAccount);
        } catch(Exception e) {
            System.out.println("Oops. Something went wrong.");
            System.exit(0);
        }

        System.out.println("Your acccount has been created successfully.");

        try {
            while(true) {
                System.out.println("1.Deposit. \n2.Withdraw.\n3.Enquiry.\n4.Exit");
                System.out.println("Enter your choice.");
                
                int choice = sc.nextInt();

                switch(choice) {
                    case 1:
                        deposit();
                        break;
                    case 2:
                        withdraw();
                        break;
                    case 3:
                        enquire();
                        break;
                    case 4:
                        System.out.println("Thank you for using the bank.");
                        System.exit(0);
                    default:
                        System.out.println("Enter a valid choice.");
                        break;
                }
            }
        } catch(InputMismatchException e) {
            System.out.println("Enter a valid input.");
        }
    }

    private static void deposit() {
        System.out.println("Enter the amount to deposit.");
        double amount = sc.nextInt();

        try {
            if(amount < 0) {
                throw new Exception();
            } 
        } catch(Exception e) {
            System.out.println("You cannot deposit a negative amount money.");
            return;
        }

        userAccount.deposit(amount);
    }

    private static void withdraw() {
        System.out.println("Enter the amount you wanna withdraw.");
        double amount = sc.nextInt();

        try {
            if(amount < 0) {
                throw new Exception();
            }
        } catch(Exception e) {
            System.out.println("You cannot withdraw a negative amount of money");
            return;
        }
        try {
            userAccount.withdraw(amount);
        } catch(InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void enquire() {
        System.out.println("You have " + userAccount.getBalance() + "$ in your account.");
    }
}