package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
     
     public Deck() {
         this.createShuffledDeck();
         //this.createDeck();
     }
     //ArrayList<Card> deck = new ArrayList();
     public ArrayList<Card> shuffledDeck = new ArrayList();
     
     private void createShuffledDeck(){
         ArrayList<Integer> list = Deck.createRandomList();
         for(int i=0;i<list.size();i++) {
             int j = list.get(i);
             Card card = new Card(j%4,j/4);
             shuffledDeck.add(card);
         }
     }
     
    public static ArrayList<Integer> createRandomList(){
        ArrayList<Integer> list = new ArrayList();
        Random random = new Random();
        int i = 0;
        while(list.size()<52) {
            int num = random.nextInt(52);
            if(list.contains(num)){
                continue;
            }
            list.add(num);
        }
        return list;
    }
    /*public void createDeckInOrder(){   
        for(int i=0;i<4;i++){
            for(int j=0;j<13;j++) {
                Card card = new Card(i, j);
                deck.add(card);
            }
        }
     }*/   
 
     /*public void shuffle() {
        ArrayList<Integer> list = Deck.createRandomList();
        for(int i=0; i<deck.size();i++) {
            shuffledDeck.add(i, deck.get(list.get(i)));
        }    
     }*/

}
