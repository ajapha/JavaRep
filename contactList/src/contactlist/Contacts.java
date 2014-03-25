package contactlist;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Aaron Japha 
 */
public class Contacts {
//contains the ArrayList for storing the contacts and methods to manage those contacts    
    private ArrayList<Contact> contacts = new ArrayList();
    
    public void addContact(Contact newContact) {
    //adds the given contact to the ArrayList contacts
        contacts.add(newContact);
    }
    
    public Contact find(String lName) {
    //finds if there are Contact(s) in the ArrayList with the given String as their last name and returns the requested Contact    
        //create a new ArrayList to store the matches found in the search
        ArrayList<Contact> matches = new ArrayList();
        //create a new Contact variable and dereference it to null to be a blank slate (and also to return null if there are no matches)
        Contact found = null;
        //loop throuh the ArrayList and save any matches to the matches ArrayList
        for(int i=0;i<contacts.size();i++) {
            if(lName.equalsIgnoreCase(contacts.get(i).getLastName())) {
                Contact m = contacts.get(i);
                matches.add(m);
            }
        }
        //If there is one match, set found to that Contact
        if(matches.size() == 1) {
            found = matches.get(0);
        }
        //if there are multiple matches call the multipleMatches function which returns one Contact. Set found to that Contact. 
        else if(matches.size() > 1) {
            found = this.multipleMatches(matches);
        }
        //returns found which will contain the requested Contact or null if no match was found
        return found;
    }
    
    protected Contact multipleMatches(ArrayList<Contact> matches) {
    //If multiple matches are found by the find function, this function asks the user to choose one of them      
        //initialize a variable to be referenced throughout the function
        Contact found = null;
        //Inform the user that there are multiple matches and ask them to choose one
        System.out.println("There are multiple contacts with that last name.  Please choose the number of the contact you are searching for.");
        //loops through the matches ArrayList and numbers each Contact starting from 1 along with the first and last name of that contact
        for(int i=0; i<matches.size();i++) {
            Contact match = matches.get(i);
            System.out.print((i+1) + ") " + match.getFirstName() + " " + match.getLastName() + "    ");
        }
        //print a line break for formatting
        System.out.println("\r");
        //receive user's input
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        //set found to the selected Contact and return found
        found = matches.get(choice-1);
        return found;
    }
    
    public void listContacts(){  
    //lists all the contacts in the ArrayList each on one line   
        //loops throuh the ArrayList, sets x to each contact and prints out that contacts info
        for(int i=0;i<contacts.size();i++) {
            Contact x = contacts.get(i);
            System.out.println("| Name: " + x.getFirstName() + " " + x.getLastName() 
                             + " | Address: " + x.getAddress()
                             + " | Phone: " + x.getPhoneNum()
                             + " | Email: " + x.getEmail() + " |");
        }
    }
    
    public void removeContact(Contact contact) {
    //removes the given contact from the ArrayList
        contacts.remove(contact);
    }


}
