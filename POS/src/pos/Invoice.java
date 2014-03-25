package pos;

import java.util.ArrayList;

public class Invoice {
    private ArrayList<LineItem> selections = new ArrayList();
    double subTotal;
    double total;
    double tax;
    double taxRate = .07;
    int subTotalInt;
    
    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal() {
        for(LineItem selection : selections) {
            this.subTotal += selection.getItemTotal();
        }
        double placeholder = subTotal * 100;
        subTotalInt = (int) placeholder;
        subTotal = subTotalInt/100.0;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal() {
        for(LineItem selection : selections) {
            if(selection.isTaxable()) {
                tax += selection.getItemTotal() * taxRate;
            }
        }
        int taxInt =(int)(tax * 100);
        tax = taxInt/100.0;
        //int totalInt = subTotalInt + taxInt;
        int totalInt = subTotalInt + taxInt;
        total =  totalInt/100.0;
    }
    
    public void addItem(Product product, int quantity) {
        LineItem item = new LineItem(product, quantity);
        selections.add(item);
    }
    
    public void showItems() {
        for(int i=0; i<selections.size();i++){
            System.out.println("Item " + (i+1) + ") " + selections.get(i).getName() + " Qty: " + selections.get(i).getQuantity()) ;
        }
        System.out.println();
    }
    public void deleteItem(int i) {
        selections.remove(i);
    }
    public int selectionsSize() {
        return selections.size();
    }
    
    public void changeQuantity(int i, int q) {
        selections.get(i).setQuantity(q);
    }
    
    public void printInvoice() {
        setSubTotal();
        setTotal();
        System.out.println("\r\nHere is your invoice");
        System.out.println("_____________________________________________________");
        System.out.println("|      Item      |  Price  |   Qty  |   Total   | T |");
        for(LineItem item : selections){
            String xsp = "";
            int spacesNum = (16 - item.getName().length()) /2;
            if(item.getName().length()%2 != 0) {
                xsp = " ";
            }
            String spaces = "";
            for(int l=0;l<spacesNum;l++) {
                spaces += " ";
            }
            
            String xspP = "";
            Double numP = item.getPrice();
            String strP = numP.toString();
            spacesNum = (8 - strP.length()) /2;
            if(strP.length()%2 != 0) {
                xspP = " ";
            }
            String spacesP = "";
            for(int l=0;l<spacesNum;l++) {
                spacesP += " ";
            }
            
            String xspQ = "";
            Integer numQ = item.getQuantity();
            String strQ = numQ.toString();
            spacesNum = (8 - strQ.length()) /2;
            if(strQ.length()%2 != 0) {
                xspQ = " ";
            }
            String spacesQ = "";
            for(int l=0;l<spacesNum;l++) {
                spacesQ += " ";
            }
            
            String xspT = "";
            Double numT = item.getItemTotal();
            String strT = numT.toString();
            spacesNum = (10 - strT.length()) /2;
            if(strT.length()%2 != 0) {
                xspT = " ";
            }
            String spacesT = "";
            for(int l=0;l<spacesNum;l++) {
                spacesT += " ";
            }
            
            System.out.println("|" + spaces + item.getName() + spaces + xsp + "|" + spacesP + "$" +item.getPrice() + spacesP + xspP + "|" + spacesQ + item.getQuantity() + spacesQ + xspQ + "|" + spacesT + "$" + item.getItemTotal() + xspT + spacesT + "| " + item.Taxable() + " |");
        }
        System.out.println("|___________________________________________________|");
        System.out.println("| Subtotal     | $" + subTotal);// +"__________________|");
        System.out.println("| 7% Sales Tax | $" + tax);// +   "___________________|");
        System.out.println("| Total        | $" + total);// +   "__________________|");
        
    }
}
