package contactlist;
import java.util.Scanner;
/**
 * @author Aaron Japha
 */

public class ContactList {
//Main class of the contact list application
    // a String to create a line break
    public static String br = System.getProperty("line.separator");
    //instantiating a Contacts object to use its methods to manage contacts
    public Contacts contactsManage = new Contacts();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instantiates the main class
        ContactList contactList = new ContactList();
        //runs the program by calling the menu function
        contactList.menu();
    }
    
    public void menu() {
    //displays a menu and calls functions based on the user's commands 
        //loops through the function until user enters 'quit'
        int loop = 0;
        while(loop !=1) {
            System.out.println(br + "Please choose from the following commands:" + br
                             + "    'add' - to add a contact" + br
                             + "    'search - to search for a contact'" + br
                             + "    'list' - to list all the contacts" + br
                             + "    'update - to change the information of a contact" + br
                             + "    'quit' - to quit the program" + br);
            //receive user command
            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();
            //call function specified by user's command
            switch (choice) {
                case "add": this.add();
                    break;
                case "search": this.search();
                    break;
                case "list": this.list();
                    break;
                case "update": this.update();
                    break;
                case "quit": loop = 1;
                             continue;
                default: System.out.println("That command is not valid. Please try again.");
            }
        }
    }
    public void add() {
    //adds a contact to the system  
        //loops through the function until user indicates they are done
        String loop = "y";
        while(loop.equalsIgnoreCase("y")) {
            System.out.println("Please enter the following information for the contact:");
            //receive the contact's first name from the user
            Scanner input = new Scanner(System.in);
            System.out.print("First Name: ");
            String fName = input.nextLine();
            //instantiate a new Contact object for the contact
            Contact newContact = new Contact();
            //set the contact's first name
            newContact.setFirstName(fName);
        
            //receive the contact's last name from the user
            System.out.print("Last Name: ");
            String lName = input.nextLine();
            //set the contact's last name
            newContact.setLastName(lName);
            
            //receive the contact's address from the user
            System.out.print("Address: ");
            String address = input.nextLine();
            //set the contact's address
            newContact.setAddress(address);
        
            //receive the contact's phone number from the user
            System.out.print("Phone Number: ");
            String phoneNum = input.nextLine();
            //set the contact's phone number
            newContact.setPhoneNum(phoneNum);
        
            //receive the contact's email address from the user
            System.out.print("Email Address: ");
            String email = input.nextLine();
            //set the contact's email address
            newContact.setEmail(email);
            
            //add the contact to the ArrayList "contacts" int the Contacts object, contactsManage 
            contactsManage.addContact(newContact);
            //Display the entered information
            System.out.println("\r This is the information you have entered for this contact");
            newContact.displayInfo(newContact);
            //ask user if they want to add another contact.  
            //If 'y' is entered the function will loop again, if not the function breaks out of the loop and returns to the main menu 
            System.out.println(br + "Do you have another contact to add?" + br 
                                  + "Enter 'y' for yes, or enter any other key to return to the main menu.");
            loop = input.nextLine();
        }
    }
    
    public void search() {
    //searches for the given contact and displays his/her information    
        //loops through the function until user indicates they are done
        String loop = "y";
        while (loop.equalsIgnoreCase("y")) { 
            //receive the contact to search for from the user
            System.out.println("Please enter the last name of the contact you would like to find.");
            Scanner input = new Scanner(System.in);
            String search = input.nextLine();
            //call the find function from the Contacts object 'contactManage' which returns a Contact object, and assign it to the Contact 'found'
            Contact found = contactsManage.find(search);
            //if the find function returns a Contact display the contact's information
            if(found != null) found.displayInfo(found);
            //if the find function returned 'null', there were no matches in the ArrayList.  Inform the user.
            else{
                //ask the user if they want to try again.  Loop until a valid response is given
                int tryAgain = 0;
                while (tryAgain != 1) {
                    System.out.println("There are no contacts in the system with that last name." + br
                                     + "Would you like to try again? y/n");
                    loop = input.next();
                    switch (loop) {
                        //will reloop through the search function
                        case "y": tryAgain = 1;
                            continue;
                        //breaks out of the current loop and the search function and returns the user to the main menu
                        case "n": tryAgain = 1;
                            continue;
                         default: System.out.print("That choice is not valid.  Please enter 'y' or 'n'");   
                    } 
                }
                //assures that if the user chose 'n' to not search again, the loop will break immediately and not show the following text
                continue;
            }
            System.out.println("To search again enter 'y', enter anyother key to return to the main menu.");
            loop = input.next();
        }
    }    
    
    public void list() {
    //lists all the contacts in the system    
        System.out.println(br);
        //Calls the listing function of the Contacts object contactsManage
        contactsManage.listContacts();
        //prompts the user to enter a key before exiting the function to make the results easier to read (otherwise the menu takes up a part of the lower screen) 
        System.out.println("Enter any key to return to the main menu");
        Scanner next = new Scanner(System.in);
        String menu = next.next();
    }

    public void update() {
    //finds a contact and allows the user to change that contact's information
        //loops through the function until user indicates they are done
        String loop = "y";
        while (loop.equalsIgnoreCase("y")) {
            //receive the last name of the contact to update from the user
            System.out.println("Please enter the last name of the contact you want to update");
            Scanner input = new Scanner(System.in);
            String search = input.nextLine();
            //Stores the return value (a Contact object) of the Contacts object contactsManage to Contact 'found' 
            Contact found = contactsManage.find(search);
            //if found is null, there is no contact with the given last name.  Inform the user and ask if they want to try again 
            if(found == null) {
                System.out.println("There is no contact in the system with that last name.  Do you want to try again? y/n"); 
                //if loop == "y" the function will loop again, otherwise the loop is broken and the user is retured to the main menu
                loop = input.next();
                continue;
            }
            //call the changeInfo function passing in the requested Contact to change the contact's info
            this.changeInfo(found);
            //ask the user if they want to update another contact.  'y' reloops through the function; any other key returns to the main menu
            System.out.println("\r Would you like to change the information of another contact? Enter 'y' for yes, otherwise enter any key.");
            loop = input.nextLine();
        }
    }
        
    public void changeInfo(Contact contact) {
    //changes the information of the given contact    
        //loops through the function until user indicates they are done
        String loop = "y";
        while(loop.equalsIgnoreCase("y")) {
            //display the given contact's current information
            System.out.println("This is the current information for the contact: \r");
            contact.displayInfo(contact);
            //instantiate a Scanner to use throughout the function
            Scanner input = new Scanner(System.in);            
            //loop until the user has made a valid selection
            int choice = -1;
            while (choice < 0 || choice > 5) {        
                System.out.println("What information would you like to change?  Enter one of the following:" + br 
                                  + "1 - for first name" +br
                                  + "2 - for last name"  +br
                                  + "3 - for address"  +br
                                  + "4 - for phone number"  +br
                                  + "5 - for email address"  +br
                                  + "Enter 0 to cancel" +br);
                //remove the given contact from the ArrayList to be replaced by the updated Contact object (done before changing the info so can still be easily found)
                contactsManage.removeContact(contact);
                //receive user's selection and call the corresponding function
                choice = input.nextInt();
                switch (choice) {
                    case 0: loop = "n"; 
                        continue;
                    case 1: this.changeFname(contact);
                        break;
                    case 2: this.changeLname(contact);
                        break;
                    case 3: this.changeAddress(contact);
                        break;
                    case 4: this.changePhoneNum(contact);
                        break;
                    case 5: this.changeEmail(contact);
                        break;
                    default: System.out.println("That selection is not valid.  Please try again \r");
                        continue;
                }
                //ask the user if they want to further change the same contact's information
                System.out.println("Would you like to change any other information for this contact? Enter 'y' for yes, otherwise enter any key.");
                //clear the scanner for the next selection
                String clear = input.nextLine();
                //receive user's selection
                loop = input.nextLine();
                //if user entered 'y' set choice to -1 to re-run the current loop, otherwise the loop will break and return to the calling function loop
                if(loop.equalsIgnoreCase("y")) {
                    choice = -1;
                }
            }
            //Once the contact is changed, display the updated info
            System.out.println("This is the updated information for the contact. \r");
            contact.displayInfo(contact);
            //add the updated contact to the system
            contactsManage.addContact(contact);
        }    
    }

    protected void changeFname(Contact contact) {
    //changes the first name of the given contact    
        System.out.println("Please enter the new first name for the contact");
        Scanner input = new Scanner(System.in);
        String newInfo = input.nextLine();
        contact.setFirstName(newInfo);
    }
    protected void changeLname(Contact contact) {
    //changes the last name of the given contact    
        System.out.println("Please enter the new last name for the contact");
        Scanner input = new Scanner(System.in);
        String newInfo = input.nextLine();
        contact.setLastName(newInfo);
    }
    protected void changeAddress(Contact contact) {
    //changes the address of the given contact   
        System.out.println("Please enter the new address for the contact");
        Scanner input = new Scanner(System.in);
        String newInfo = input.nextLine();
        contact.setAddress(newInfo); 
    }
    protected void changePhoneNum(Contact contact) {
    //changes the phone number of the given contact
        System.out.println("Please enter the new phone number for the contact");
        Scanner input = new Scanner(System.in);
        String newInfo = input.nextLine();
        contact.setPhoneNum(newInfo);
    }
    protected void changeEmail(Contact contact) {
    //changes the email address of the given contact 
        System.out.println("Please enter the new email address for the contact");
        Scanner input = new Scanner(System.in);
        String newInfo = input.nextLine();
        contact.setEmail(newInfo);
    }
    
}
                