package pos;

import java.util.Scanner;

public class POS {
    Invoice invoice = new Invoice();
        
    public static void main(String[] args) {
        //I did this instead of having all static methods in the main class so I could 
        //access the invoice class in other methods in this class.
        POS pos = new POS();
        Products.fillProducts();
        Scanner input = new Scanner(System.in);
        String next = "";
        while(!next.equalsIgnoreCase("done")) {
            System.out.println("Welcome to Java Grocery Store \rPlease make your selection from our products below by entering the number of the product.");
            for(int i=0; i<Products.products.size(); i++) {
                System.out.println(i+1 + ") " + Products.products.get(i).getName() + "    " + "$" + Products.products.get(i).getPrice());
            }
            int choice = pos.getIntBetween(input, 1, Products.products.size());
            input.nextLine();
            System.out.println("How many");
            int quantity = pos.getInt(input);
            input.nextLine();
            pos.invoice.addItem(Products.products.get(choice-1), quantity);
            int loop = 0;
            while(loop == 0) {
                System.out.println("Your cart contains:  ");
                pos.invoice.showItems();
                System.out.println("Enter 'shop' to select more items for your cart.\n"
                        + "Enter 'remove' to remove an item from your cart.\n"
                        + "Enter 'change' to change the quantity of an item in your cart\n"
                        + "Enter 'done' to proceed to checkout.");
                next = input.nextLine();
                switch(next) {
                    case "remove": pos.remove();
                        break;
                    case "shop": loop = 1;
                        continue;
                    case "change": pos.change();
                        break;
                    case "done":
                        loop = 1;
                        continue; 
                    default: System.out.println("That is an invalid selection.  Please try again");
                }
            }
        }
        pos.invoice.printInvoice();
    }
    public void remove() {
        invoice.showItems();
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if(choice > invoice.selectionsSize()){
            System.out.println("That selection is not valid");
            return;
        }
        invoice.deleteItem(choice-1);
        System.out.println("");
    }
    public void change() {
        invoice.showItems();
        System.out.println("Which item's quantity do you want to change?");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if(choice > invoice.selectionsSize()){
            System.out.println("That selection is not valid");
            return;
        }
        input.nextLine();
        System.out.println("What is the quantity you would like?");
        int quantity = input.nextInt();
        invoice.changeQuantity(choice-1, quantity);
    }
    public int getInt(Scanner sc) {
        while (true) {
            if(sc.hasNextInt()) {
                int number = sc.nextInt();
                return number;
            }
            else {
                System.out.println("That is not a valid number.  Please try again.");
                sc.nextLine();
            }
        }
    }
    public int getIntBetween(Scanner sc, int min, int max) {
        while (true) {
            if(sc.hasNextInt()) {
                int number = sc.nextInt();
                if(number < min || number > max) {
                    System.out.println("That is not a valid selection.  Please enter a number between " + min + " and " + max + ".");
                    sc.nextLine();
                    continue;
                }
                return number;
            }
            else {
                System.out.println("That is not a valid number.  Please try again.");
                sc.nextLine();
            }
        }
    }
    
}
