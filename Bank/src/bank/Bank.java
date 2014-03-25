package bank;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Aaron Japha
 */
public class Bank {
    ArrayList<Account> accounts = new ArrayList();
    
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.run();
        bank.monthEnd();
    }
    
    public void run() {
        boolean loop = false;
        while(loop == false) {
            System.out.println("Welcome to Java Bank\n Please choose from the following commands.\n"
                    + "'new' - to open a new account\n"
                    + "'login' - to log in to an existing account\n"
                    + "'quit' - to exit the system\n");
            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();
            switch (choice) {
                case "new": newAccount();
                    break;
                case "login": logIn();
                    break;
                case "quit": loop = true;
                    break;
                default: System.out.println("You have entered an invalid entry.  Please try again.");
            }
        }  
    }
    public void newAccount() {
        boolean loop = false;
        while (loop == false) {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter a username for the account");
            String userName = input.nextLine();
            System.out.println("Please enter a case sensitive password for the account");
            String password = input.nextLine();
            System.out.println("What type of account do you want to open?\n Please enter 'checking' or 'savings'.");
            String accountType = input.nextLine();
            switch (accountType) {
                    case "savings": savings(userName, password);
                        loop = true;
                        break;
                    case "checking": checking(userName, password);
                        loop = true;
                        break;
                    case "quit": loop = true;
                        break;
                    default: System.out.println("You have entered an invalid entry.  Please try again.");
            }
    
        }
    }
    public void logIn() {
        Account loggedIn = null;
        boolean loop = false;
        while(loop == false) {
            System.out.println("Please enter your username.");
            Scanner input = new Scanner(System.in);
            String userName = input.nextLine();
            System.out.println("Please enter your password. (Remember passwords are case sensitive.)");
            String password = input.nextLine();
            for (Account account : accounts) {
                if(account.getUserName().equalsIgnoreCase(userName) && account.getPassword().equals(password)) {
                    loggedIn = account;
                    this.accountManage(loggedIn);
                    loop = true;
                } 
            }
            if(loggedIn == null) {
                System.out.println("We can not verify your information.\n  Enter 'y' to try again or any other key to return to the main menu.");
                String retry = input.nextLine();
                if(!retry.equalsIgnoreCase("y")) {
                    loop = true;
                    continue;
                }
            }
        }    
    }
   
    public void accountManage(Account account) {
        System.out.println("Welcome back " + account.getUserName() + "\n"
                + "Account Number " + account.getAccountNumber() + "\n"
                + "Your current balance is " + account.getBalance() + "\n"
                + "To enter transactions press enter\n");
        Scanner input = new Scanner(System.in);
        input.nextLine();
        double amount = 0;
        String again = "y";
        while (again.equalsIgnoreCase("y")) {
            System.out.println("Is the transaction a debit or credit? Please enter 'd' or 'c'.");
            String type = input.nextLine();
            if(!type.equalsIgnoreCase("c") && !type.equalsIgnoreCase("d")) {
                System.out.println("That is not a valid selection.  Please try again.");
                continue;
            }
            while(true) {
                System.out.println("How much is the transaction for?");
                if(!input.hasNextDouble()) {
                    System.out.println("That is not a valid amount.  Please try again."); 
                    continue;
                }
                break;
            }
            amount = input.nextDouble();
            if(type.equalsIgnoreCase("d")) {
                amount = 0 - amount;
            }
            account.addTransaction(amount);
            again = input.nextLine();
            System.out.println("Your balance is now " + account.getBalance() + ".\n"
                    + "Do you want to enter another transaction. Enter 'y' for yes, or any other key to return to the main menu.");
            again = input.nextLine();
        }
    }
    
    
    public void savings(String userName, String password) {
        Savings savings = null;
        boolean loop = false;
        while (loop == false) {
            System.out.println("Please enter the starting balance for your new savings account.");
            Scanner input = new Scanner(System.in);
            if(input.hasNextDouble()) {
                savings = new Savings(userName, password, input.nextDouble());
                accounts.add(savings);
                loop = true;
            }
            else {
                System.out.println("The starting balance entered is not valid.");
            }
        }
        System.out.println("Thank you for opening an account with us.\n"
                         + "Your new savings account number is " + savings.getAccountNumber() + " and you have a starting balance of " + savings.getBalance() + ".\n"
                         + "You can now log in to your account to add transactions\n\n");
       
    }
    
    public void checking(String userName, String password) {
        Checking checking = null;
        boolean loop = false;
        while(loop == false) {
            System.out.println("Please enter the starting balance for your new checking account.");
            Scanner input = new Scanner(System.in);
            if(input.hasNextDouble()) {
                checking = new Checking(userName, password, input.nextDouble());
                accounts.add(checking);
                loop = true;
            }
            else {
                System.out.println("The starting balance entered is not valid.");
            }
        }
        System.out.println("Thank you for opening an account with us.\n"
                         + "Your new checking account number is " + checking.getAccountNumber() + " and you have a starting balance of " + checking.getBalance() + ".\n"
                         + "You can now log in to your account to add transactions.\n\n");
           
    }

    public void monthEnd() {
        for(Account account : accounts) {
            account.endOfMonth();
            account.print();
            System.out.println(account.getBalance());
        }
    }
}
