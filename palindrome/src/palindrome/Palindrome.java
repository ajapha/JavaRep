/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;
import java.util.Scanner;
/**
 *
 * @author AJ
 */
public class Palindrome {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Give me a string and I will tell you if it is a palindrome.");
        String input1 = scanner.nextLine();
        String input2 = input1.replaceAll("\\s","");
        int x = input2.length() - 1;
        int i = 0; 
      for (i=0; i<=x; i++, x--) {
        System.out.println(input2.charAt(i) + ":" + input2.charAt(x));
        if (input2.charAt(i) != input2.charAt(x)) {
            i=100;
        }
      }  
      if (i == 101) {
        System.out.println(input1 + " is not a palindrome.");  
      } else {
        System.out.println(input1 + " is a palindrome.");  
        }
    }
}
