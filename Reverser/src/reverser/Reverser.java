package reverser;
import java.util.Scanner;

public class Reverser {

    public static void main(String[] args) {
        Reverser r = new Reverser();
        System.out.println("Please enter some words and I will reverse them.");
        Scanner input = new Scanner(System.in);
        String words = input.nextLine();
        r.reverseWords1(words);
        System.out.println(r.reverseWords2(words));
        System.out.println(r.reverseWords3(words));
        System.out.println(r.reverseWords4(words));
    }

    //Simple method using split 
    public void reverseWords1(String string) {
        String[] words = string.split(" ");
        for(int i=words.length-1;i>=0;i--){
           System.out.print(words[i]+' ');
        }
        System.out.println();
    }
    
    //convaluted method (I didn't think so when I wrote it) that uses no built in functions
    public String reverseWords2(String string) {
        String[]words = new String[30];
        String reversed = "";
        int wordStart = 0;
        int wordEnd;
        int wordsStored = 0;
        int j =0;
        for(int i=0;i<string.length();i++) {
            if(string.charAt(i) != ' ') j++; 
            if((string.charAt(i) == ' ' || i==string.length()-1) && j !=0 ){
                wordEnd = i-1;
                if(i==string.length()-1) 
                    wordEnd = i;
                String word = "";
                for(int l=wordStart;l<=wordEnd;l++) {
                    word += string.charAt(l); 
                    words[wordsStored] = word;
                }
                wordStart = i+1;
                wordsStored++;
            }    
        }
        for(int i=wordsStored-1; i>=0;i--) {
            if(words[i]!=null)
            reversed += words[i]+" ";
        }
        return reversed;
    }
  
    //best method uses only loops and works in all scenarios
    public String reverseWords3(String string) {
        String reversed = "";
        int wordStart;
        int wordEnd = string.length()-1;
        int j =0;
        for(int i = wordEnd;i>=0;i--) {
            if(string.charAt(i) != ' ') j++;
            if((string.charAt(i) == ' ' || i==0) && j !=0) {
                wordStart = i+1;
                if(i==0) wordStart = i;
                for(int l=wordStart;l<=wordEnd;l++) {
                reversed += string.charAt(l);
                }
            reversed += ' ';
            wordEnd = i-1;
            }
        }
        return reversed;
    }
    
    //same as 3 except doesn't even use string.length()
    public String reverseWords4(String string) {
        String reversed = "";
        int wordStart;
        int wordEnd = this.strln(string)-1;
        int j =0;
        for(int i = wordEnd;i>=0;i--) {
            if(string.charAt(i) != ' ') j++;
            if((string.charAt(i) == ' ' || i==0) && j !=0) {
                wordStart = i+1;
                if(i==0) wordStart = i;
                for(int l=wordStart;l<=wordEnd;l++) {
                reversed += string.charAt(l);
                }
            reversed += ' ';
            wordEnd = i-1;
            }
        }
        return reversed;
    }
    
    public int strln(String string) {
        int length = 0;
        int i=0;
        try{
            for(;i==i;i++) {
                string.charAt(i);
            }
        }
        catch(Exception e) {
            length = i;        
        }
        return length;    
    }
}

