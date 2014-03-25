package contactlist2;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactList2 {

    public static void main(String[] args) {
        ArrayList<Contact> contacts = new ArrayList();
        FileManage fm = new FileManage();
        String again = "yes";
        while (again.equals("yes")) {
        System.out.println("Please enter a contact to add.\r\nName: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Phone Number: ");
        String number = sc.nextLine();
        Contact contact = new Contact(name, number);
        fm.addToFile(contact);
        
        System.out.println("Do you have another contact to add.");
        again = sc.nextLine();
        }
        fm.closeOos();
        System.out.println("Here is your contacts info");
        contacts = fm.readFromFile();
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("Name: " + contacts.get(i).getName() + "\r\nNumber: " + contacts.get(i).getNumber());
        }
    }
    
}
