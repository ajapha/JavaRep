package pos;

import java.util.ArrayList;


public class Products {
    public static ArrayList<Product> products = new ArrayList();
   
    public static void fillProducts() {
        Product product = new Product(4.39, "Cheerios", false);
        products.add(product);
        product = new Product(1.39, "Elbow Macaroni", false);
        products.add(product);
        product = new Product(6.99, "Paper Towels", true);
        products.add(product);
        product = new Product(1.99, "Paper Plates", true);
        products.add(product);
        product = new Product(10.99, "Diapers", true);
        products.add(product);
        product = new Product(2.99, "Orange Juice", false);
        products.add(product);
        product = new Product(2.99, "Apples", false);
        products.add(product);
        product = new Product(2.49, "Potatoes", false);
        products.add(product);
        product = new Product(2.49, "Milk", false);
        products.add(product);
        product = new Product(1.99, "Onions", false);
        products.add(product);
        product = new Product(1.49, "Plastic Cups", true);
        products.add(product);
        product = new Product(1.19, "Pepsi", true);
        products.add(product);
        
    } 
}
