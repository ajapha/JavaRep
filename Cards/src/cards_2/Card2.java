package cards_2;

public class Card2 {
    public enum Suit {
        HEARTS,
        DIAMONDS,
        CLUBS,
        SPADES;
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
    private Suit suit;
    private Value value;
    private String symbol;
    private String numValue;
    
    public Card2(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
        setSymbol(suit);
        setNumValue(value);
    }
    
    private void setNumValue(Value value) {
        switch(value.ordinal()) {
            case 0: numValue = "A";
                break;
            case 1: numValue = "2";
                break;
            case 2: numValue = "3";
                break;    
            case 3: numValue = "4";
                break;   
            case 4: numValue = "5";
                break;
            case 5: numValue = "6";
                break;
            case 6: numValue = "7";
                break;
            case 7: numValue = "8";
                break;
            case 8: numValue = "9";
                break;
            case 9: numValue = "10";
                break;
            case 10: numValue = "J";
                break;
            case 11: numValue = "Q";
                break;
            case 12: numValue = "K";
                break;
        }
    }
    
    
    
    private void setSymbol(Suit suit){
        switch(suit.ordinal()){
            case 0: symbol = "\u2661";//u2665
                break;
            case 1: symbol = "\u2662";//\u2666
                break;
            case 3: symbol = "\u2660";
                break;  
            case 2: symbol = "\u2663";
                break;    
        }
    }
    public String getSymbol(){
        return symbol;
    }

    public Value getValue() {
        return value;
    }
    public Suit getSuit() {
        return suit;
    }
    public void displayCard(){
        String top = "|" + numValue + "     |"; 
        String bottom = "|_____" + numValue + "|";
        if(this.value.ordinal() == 9) {
            top = "|" + numValue + "    |";
            bottom = "|____" + numValue + "|";
        }
        System.out.println(" ______ "); 
        System.out.println(top); 
        System.out.println("|      |"); 
        System.out.println("|   "+ getSymbol()+"  |"); 
        System.out.println("|      |"); 
        System.out.println(bottom);
        System.out.println();
            
    }

}
