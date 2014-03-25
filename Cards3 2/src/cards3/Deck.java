package cards3;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();
    
    public Deck() {
        //Card card = new Card(Card.Suit.DIAMONDS, 27);
        //System.out.println(card.getSuit());
        //int ordinal = Card.Suit.HEARTS.ordinal();
        for(Card.Suit suit : Card.Suit.values()) {
            for(Card.Value value : Card.Value.values()) {
                cards.add(new Card(suit, value));
            }
        }
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    public String toString() {
        String retVal = "";
        for(Card card : cards) {
            retVal += card.toString();
            retVal += "\r\n";
        }
        return retVal;
    }
}
