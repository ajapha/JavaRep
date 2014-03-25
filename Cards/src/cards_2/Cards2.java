package cards_2;

import java.io.IOException;
import java.util.Stack;

public class Cards2 {
    Stack<Card2> Player1 = new Stack();
    Stack<Card2> Player2 = new Stack();
    Deck2 deck = new Deck2();
    
    public static void main(String[] args) {
        Cards2 cards = new Cards2();
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
        deck.makeShuffledDeck();
        deal();
        run();
    }
    
    public void deal() {
        for(int i=0; i<deck.deck.size();i++) {
            if(i%2 ==0) {
                Player1.push(deck.deck.get(i));
            } else{
                  Player2.push(deck.deck.get(i));
            }
        }
    }
    public void run() {
        while(!Player1.empty() && !Player2.empty()) {
            System.out.println("Player 1's card");
            Card2 card1 = Player1.pop();
            card1.displayCard();
            System.out.println();
            System.out.println("Player 2's card");
            Card2 card2 = Player2.pop();
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
    
    public int war(Card2 card1, Card2 card2) {
        Card2[] cards = new Card2[8];
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
        Card2 warCard1 = Player1.pop();
        warCard1.displayCard();
        System.out.println("Player 2's cards");
        card2.displayCard();
        for(int i=0; i<amountOfCards2;i++) {
            displayBlankCard();
        }
        Card2 warCard2 = Player2.pop();
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
    public int determineWinner(Card2 card1, Card2 card2) {
        int winner = 0;
        if (card1.getValue().ordinal() > card2.getValue().ordinal()) {
            System.out.println("Player 1 Wins the round");
            addCardsToWinner(Player1, card1, card2);
            winner = 1;
        }
        else if (card2.getValue().ordinal() > card1.getValue().ordinal()) {
            System.out.println("Player 2 Wins the round");
            addCardsToWinner(Player2, card1, card2);
            winner = 2;
        }
        else if(card2.getValue().ordinal() == card1.getValue().ordinal()) {
            System.out.println("WAR! \r Press enter to begin the war");
            try {
                System.in.read();
            } catch (IOException e) {
            }
            winner = war(card1, card2);
        }
        return winner;
    }

    public void addCardsToWinner(Stack<Card2> stack, Card2 card1,Card2 card2) {
        stack.add(0, card1);
        stack.add(0, card2);
    }
    public void addCardsToWinner(Stack<Card2> stack, Card2[] cardsToAdd) {
        for(int i=0, j=cardsToAdd.length; i<j; i++) {
            stack.add(0, cardsToAdd[i]);
        }
    }
    
}    

