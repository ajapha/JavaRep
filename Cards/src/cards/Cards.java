package cards;

import java.io.IOException;
import java.util.Stack;

public class Cards {
    Stack<Card> Player1 = new Stack();
    Stack<Card> Player2 = new Stack();
    Deck deck = new Deck();
    
    public static void main(String[] args) {
        Cards cards = new Cards();
        System.out.println("Welcome to WAR!");
        System.out.println("Press enter to start the game");
        System.out.println();
         try {
                System.in.read();
         } 
         catch (IOException e) {
         }
        System.out.println("Shuffling the cards...");
        System.out.println("Dealing the cards...");
        cards.start();
    }   
    
    public void start() {
        deal();
        run();
    }
    
    public void deal() {
        for(int i=0; i<deck.shuffledDeck.size();i++) {
            if(i%2 ==0) {
                Player1.push(deck.shuffledDeck.get(i));
            } else{
                  Player2.push(deck.shuffledDeck.get(i));
            }
        }
    }
    public void run() {
        while(!Player1.empty() && !Player2.empty()) {
            System.out.println("Player 1's card");
            Card card1 = Player1.pop();
            card1.displayCard();
            System.out.println();
            System.out.println("Player 2's card");
            Card card2 = Player2.pop();
            card2.displayCard();
            determineWinner(card1, card2);
            if(Player1.empty() || Player2.empty()) {
                continue;
            }
            System.out.println("Player 1 now has " + Player1.size() + " cards in his stack");
            System.out.println("Player 2 now has " + Player2.size() + " cards in his stack");
            System.out.println("Press enter for the next turn");
            try {
                System.in.read();
            } catch (IOException e) {
            }
        }
        if(Player1.empty()) {
            System.out.println("Player 2 wins the game!");   
        }
        else {
            System.out.println("Player 1 wins the game!");
        }
    }
    
    public int war(Card card1, Card card2) {
        Card[] cards = new Card[8];
        int amountOfCards1 = 3;
        int amountOfCards2 = 3;
        cards[6] = card1;
        cards[7] = card2;
        if(Player1.size()>=4) {
            for(int i=0;i<3;i++) {
                cards[i] = Player1.pop();
            }
        }
        else{
            for(int i=0;i<Player1.size()-1;i++) {
                cards[i] = Player1.pop();
            }
            amountOfCards1 = Player1.size()-1;
        }
        if(Player2.size()>=4) {
            for(int i=3;i<6;i++) {
                cards[i] = Player2.pop();
            }
        }
        else{
            for(int i=0;i<Player2.size()-1;i++) {
                cards[i] = Player2.pop();
            }
            amountOfCards2 = Player2.size()-1;
        }
        System.out.println("Player 1's cards");
        card1.displayCard();
        for(int i=0; i<amountOfCards1;i++) {
            displayBlankCard();
        }
        Card warCard1 = Player1.pop();
        warCard1.displayCard();
        System.out.println("Player 2's cards");
        card2.displayCard();
        for(int i=0; i<amountOfCards2;i++) {
            displayBlankCard();
        }
        Card warCard2 = Player2.pop();
        warCard2.displayCard();
        int winner = determineWinner(warCard1, warCard2);
        if(winner==1) {
            addCardsToWinner(Player1, cards);
            return 1;
        } else if(winner==2){
            addCardsToWinner(Player2, cards);
            return 2;
        }
        return 0;
    }
    
    public void displayBlankCard() {
        System.out.println(" ______ "); 
        System.out.println("|000000|"); 
        System.out.println("|000000|"); 
        System.out.println("|000000|"); 
        System.out.println("|000000|"); 
        System.out.println("|______| ");
    }
    public int determineWinner(Card card1, Card card2) {
        int winner = 0;
        if (card1.getIntValue() > card2.getIntValue()) {
            System.out.println("Player 1 Wins the round");
            addCardsToWinner(Player1, card1, card2);
            winner = 1;
        }
        else if (card2.getIntValue() > card1.getIntValue()) {
            System.out.println("Player 2 Wins the round");
            addCardsToWinner(Player2, card1, card2);
            winner = 2;
        }
        else if(card2.getIntValue() == card1.getIntValue()) {
            System.out.println("WAR! \r Press enter to begin the war");
            try {
                System.in.read();
            } catch (IOException e) {
            }
            winner = war(card1, card2);
        }
        return winner;
    }

    public void addCardsToWinner(Stack<Card> stack, Card card1,Card card2) {
        stack.add(0, card1);
        stack.add(0, card2);
    }
    public void addCardsToWinner(Stack<Card> stack, Card[] cardsToAdd) {
        for(int i=0, j=cardsToAdd.length; i<j; i++) {
            stack.add(0, cardsToAdd[i]);
        }
    }
    
}
//test deal
 /*for (int i=0;i<12;i++){
            Card card = new Card(3, i);
            Player1.push(card);
            Player2.push(card);
        }
        Card card = new Card(3, 8);
        Player1.add(0, card);
        card = new Card(3, 2);
        Player2.add(0, card);
        card = new Card(1, 4);
        Player1.add(0, card);
        card = new Card(3, 4);
        Player2.add(0, card);
        card = new Card(1, 4);
        Player1.add(0, card);
        Player2.add(0, card);
        card = new Card(1, 8);
        Player2.add(0, card);
        card = new Card(3, 1);
        Player1.add(0, card);
        card = new Card(3, 9);
        Player2.add(0, card);*/

//test print out
/*deck.createDeck();
        for(int i=0;i<deck.deck.size();i++) {
            Card card = deck.deck.get(i);
            card.displayCard();
        }*/
       
