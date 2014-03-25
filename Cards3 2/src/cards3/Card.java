package cards3;

public class Card {
    public enum Suit {
        HEARTS,
        CLUBS,
        SPADES,
        DIAMONDS;
        
        /*public String toString() {
            return this.name();
        }*/
        
        public String toString() {
            String temp = name().substring(0,1).toUpperCase();
            return temp + name().substring(1).toLowerCase();
        }
    }
    
    public enum Value {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING
    }
    
    private Value value;
    private Suit suit;
     
    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }
    
    public Value getValue() {
        return value;
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    public String toString() {
        String retVal = value.toString();
        retVal += " of ";
        retVal += suit.toString();
        return retVal;
    }
}
