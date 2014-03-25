package contactlist2;

import java.io.Serializable;

public class Contact implements Serializable{
    private String name;
    private String number;

    Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String Number) {
        this.number = Number;
    }

}
