/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bank;

/**
 *
 * @author AJ
 */
public class Savings extends Account {
    final double interestRate = .01;
    
    public Savings(String userName, String password, double balance) {
        super(userName, password, balance);
    }
    
    @Override
    public void endOfMonth() {
        balance = balance * (1.0 + interestRate);
    }
    @Override
    public void print() {
        super.print();
        System.out.println("Account Type: Savings");
        System.out.println();
    }
 
}
