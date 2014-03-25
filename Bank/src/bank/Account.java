package bank;

import java.text.NumberFormat;
import java.util.Random;

/**
 *
 * @author AJ
 */
public class Account implements Printable{
  
    protected double balance;
    private String userName;
    private String password;
    private String accountNumber;
    
    
    public Account(String userName, String password, double balance) {
        this.userName = userName;
        this.password = password;
        this.balance = balance;
        Integer acctNum = new Random().nextInt(12345) + 1111100;
        this.accountNumber = acctNum.toString();
    }
    public String getBalance() {
        NumberFormat dollars = NumberFormat.getCurrencyInstance();
        return dollars.format((double) balance);
    }
    public String getUserName() {
        return this.userName;
    }
    public String getPassword() {
        return this.password;
    }
    public String getAccountNumber() {
        return this.accountNumber;
    }
    
    public String getType() {
        String type = this.getClass().getName();
        type = type.substring(5);
        return type;
    } 
    public void addTransaction(double amount) {
        if(amount > 0 || amount < 0) {
            balance += amount;
        }
        else{
            System.out.println("That is not a valid transaction.");
        }
    }
    
    public void endOfMonth() {
        
    }
    
    @Override
    public void print() {
        System.out.println("Username:  " + this.getUserName());
        System.out.println("Account Number:  " + this.getAccountNumber());
        System.out.println("Account Balance:  " + this.getBalance());
    }    
}
