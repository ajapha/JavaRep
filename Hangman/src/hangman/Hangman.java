/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman;
import static java.lang.Character.isLetter;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author AJ
 */
public class Hangman {
    public static String [] words = {"house", "clue", "brown", "cowboy", "special", "joy", "coin", "glue", "new", "loud", "point", "out", "down", "now", "stay", "clay", "plain", "mail", "keep", "green", "seat", "dream", "mean", "chief", "idea", "thief", "fields"};//, "girl", "baby", "instead", "shred", "success", "java", "people", "pizza", "burn", "brother", "first", "third", "bread", "field", "head", "last", "bird", "herd", "everything", "sister"}; //static b/c shared by all hangman games  
    public int outs = 0;
    public char [] guesses;
    public Hangman() { //constructor
      
    }
   
    public static void main(String[] args) {
      Hangman hangman = new Hangman();
      hangman.start();
    }
    
    public void drawGuesses() {
      for(int i=0;i< guesses.length; i++) {
          if (isLetter(guesses[i])) { //>= 'a' && guesses[i] <= 'z') {
              System.out.print(guesses[i]);
          } else {  
              System.out.print("_ ");
          }
      }  System.out.println(); 
    }
    
    public void drawScreen() {
        System.out.println();
        drawGuesses();
        drawPerson();
    }
    public void start() {
      int number = new Random().nextInt(words.length);
      String theWord = words[number];
      String theWord2 = theWord;
      guesses = new char[theWord.length()];
      String picked = "You already guessed:";
      System.out.println("Try to guess the word");
      Scanner scanner = new Scanner(System.in);
      int winner = 0;
        while(outs <= 10 && winner != 100) {
          drawScreen();
          System.out.println(picked);
          char guess = scanner.next().charAt(0);
            if(theWord.indexOf(guess)==-1) {
                outs++;
                }
          picked += " " + guess + ",";  
            while(theWord.indexOf(guess) >= 0) {
                int position = theWord.indexOf(guess); 
                  guesses[position] = theWord.charAt(position); 
                  theWord = theWord.substring(0,position) + "." + theWord.substring(position+1);
                    int t = 1;
                    for (int i=0; i<theWord2.length();i++) {  
                      if(theWord2.charAt(i) != guesses[i]) {
                          t=0;
                      } 
                    }
                      if(t == 1) { 
                        winner = 100;
                      }
                  }
                  if (outs > 10) {
                    System.out.println("You Lost");
                  } else if (winner == 100) {
                      System.out.println(guesses);
                      System.out.println("You Won!");
                    }
        }
    }
    public void drawPerson() {
      String one = " ________";
      String two = " |/      ";
      String three = " |";
      String four = " |";
      String five = " |";
      String six = " |";
      String seven = "_|_____       ";
    
      if (outs >= 1) {
        two = " |/     |";
      }
      if (outs == 2) {
       three = " |    (   )";
      }else if (outs == 3) {
       three = " |    (' ')";   
      } else if (outs >= 4) {
       three = " |    (',')";
      }
      if(outs == 5) {
        four = " |      | ";
      }
      if(outs == 6) {
        four = " |     \\| ";
      }
      if(outs >= 7) {
        four = " |     \\|/";
      }
      if(outs >= 8) {
       five = " |      |";    
      }
      if(outs == 9) {
        six = " |     / ";  
      }
      if(outs == 10) {
        six = " |     / \\";
      }
    
    String man [] = {one,two,three,four,five,six,seven};
    for (int i = 0; i<= man.length-1;i++) {
        System.out.println(man[i]);
    }
    


  }
}
