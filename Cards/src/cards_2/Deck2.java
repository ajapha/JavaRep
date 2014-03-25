package cards_2;

import java.util.ArrayList;
import java.util.Collections;

public class Deck2 {
    public ArrayList<Card2> deck = new ArrayList();
     
    public void makeShuffledDeck() {
         for(Card2.Suit suit : Card2.Suit.values()) {
             for(Card2.Value value : Card2.Value.values()) {
                 deck.add(new Card2(suit, value));
             }
         }
         Collections.shuffle(deck);
     }    
}
