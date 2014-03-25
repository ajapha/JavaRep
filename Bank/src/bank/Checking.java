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
public class Checking extends Account {

    public Checking(String userName, String password, double balance) {
        super(userName, password, balance);
    }
    
    @Override
    public void endOfMonth() {
        if(balance < 1000) {
            balance -= 10;
        }
    }
    @Override
    public void print() {
        super.print();
        System.out.println("Account Type: Checking");
        System.out.println();
    }
    
}
