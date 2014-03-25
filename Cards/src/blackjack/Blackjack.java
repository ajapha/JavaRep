package blackjack;

import cards.Card;
import cards.Deck;
import java.util.Stack;

public class Blackjack {
    Deck deck = new Deck();
    Card card1;
    Card card2;
    Stack<Card> stack = new Stack();    
    
    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack();
        blackjack.start();
    }  
    
    public void start() {
        fillStack();
        deal();
    }
    public void run(){
        
    }
    
    public void deal(){
        this.displayBlankCard();
        Card card1 = stack.pop();
        Card card2 = stack.pop();
        card2.displayCard();
    }
    
    public void fillStack(){
        for(int i=0;i<deck.shuffledDeck.size();i++) {
            Card card = deck.shuffledDeck.get(i);
            stack.add(i, card);
        }
    }
    
    public void displayBlankCard() {
        System.out.println(" ______ "); 
        System.out.println("|000000|"); 
        System.out.println("|000000|"); 
        System.out.println("|000000|"); 
        System.out.println("|000000|"); 
        System.out.println("|______| ");
    }
}
