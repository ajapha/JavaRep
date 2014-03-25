package contactlist;
/**
 * @author Aaron Japha
 */
public class Contact {
//Contains the properties and methods of a contact in the system 
    //a String to be used for formating a line break
    public static String br = System.getProperty("line.separator");
    
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNum;
    private String email;
    
    //getters and setters for the above properties
    public void setFirstName(String fname) {
        this.firstName = fname;
    }
    public String getFirstName() {
        return this.firstName;
    } 
    public void setLastName(String lname) {
        this.lastName = lname;
    }   
    public String getLastName() {
        return this.lastName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public String getPhoneNum() {
        String ph = this.phoneNum;
        //if phone number is 10 digits long, format it with dashes
        if (this.phoneNum.length() == 10) {
            ph = this.phoneNum.substring(0, 3) + "-" + this.phoneNum.substring(3, 6) + "-" + this.phoneNum.substring(6, 10);
        }
        return ph;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void displayInfo(Contact contact) {
    //displays the given contact's info
        String ph = contact.getPhoneNum();
        System.out.println("    Name: " + contact.getFirstName() + " " + contact.getLastName() + br
                         + "    Address: " + contact.getAddress() + br
                         + "    Phone Number: " + contact.getPhoneNum() + br
                         + "    Email Address: " + contact.getEmail() + br);
    }
}
