/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package intvector;

public class IntVector {
    int[] intArray = new int [100];
    int d = 0;
//private void intvector() {
    public void addTo() {
      int l = intArray.length;
      //if(d == l) {
        int [] newIntArray = new int [l*2];
          for(int x=0; x<l; x++) {
            newIntArray[x] = intArray[x];
        //  }  
        }
         intArray = newIntArray;
    }
    public void add(int x) {
      if(d == intArray.length-1) {
          this.addTo();
      }
      intArray[d] = x;
      //System.out.println(d + " : " + x);
      //System.out.println(intArray[d]);
      //System.out.println(d);
      d++;
    }
    
    public int get(int index){
      return intArray[index];
    }
    
    public static void main(String [] args){
        IntVector intVector = new IntVector();
        for(int i = 0; i < 150; i++){
            intVector.add(i); 
        }
        for(int i = 0; i < 150; i++){
            //System.out.println(i);
            System.out.print(intVector.get(i) + " ");
        }
    }
}
