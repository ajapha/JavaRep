package cards;

public class Card {

    private String suit;
    private int intSuit;
    private String symbol;
    private String value;
    private int intValue;
    
    public Card(int suit, int value) {
        this.intSuit= suit;
        setSuit(suit);
        setSymbol(this.suit);
        this.intValue = value;
        setValue(intValue);
    }
    
    public int getIntSuit() {
        return intSuit;
    }

    //private void setIntSuit(int intSuit) {
      //  this.intSuit = intSuit;
    //}
    

    public String getSuit() {
        return suit;
    }

    private void setSuit(int suitNum) {
        switch(suitNum) {
            case 0: this.suit = "hearts";
                break;
            case 1: this.suit = "diamonds";
                break;
            case 2: this.suit = "spades";
                break;
            case 3: this.suit = "clubs";
               
        }
    }
    
    private void setSymbol(String suit){
        switch(suit){
            case "hearts": symbol = "\u2661";//u2665
                break;
            case "diamonds": symbol = "\u2662";//\u2666
                break;
            case "spades": symbol = "\u2660";
                break;  
            case "clubs": symbol = "\u2663";
                break;    
        }
    }
    public String getSymbol(){
        return symbol;
    }

    public String getValue() {
        return value;
    }

    private void setValue(int intValue) {
        switch(intValue) {
            case 0: this.value = "A";
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:  Integer transform = intValue+1;
                this.value = transform.toString();
                break;    
            case 10: this.value = "J";
                break;
            case 11: this.value = "Q";
                break;
            case 12: this.value = "K";
                break;
        }
    }
    
    public int getIntValue(){
        return intValue;
    }
    
    public void displayCard(){
        String top = "|" + this.getValue( )+"     |"; 
        String bottom = "|_____"+ this.getValue()+"|";
        if(this.getIntValue() == 9) {
            top = "|" + this.getValue( )+"    |";
            bottom = "|____"+ this.getValue()+"|";
        }
        System.out.println(" ______ "); 
        System.out.println(top); 
        System.out.println("|      |"); 
        System.out.println("|   "+ this.getSymbol()+"  |"); 
        System.out.println("|      |"); 
        System.out.println(bottom);
        System.out.println();
            
    }
    
}
