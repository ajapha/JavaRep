package contactlist2;

import java.io.*;
import java.util.ArrayList;

public class FileManage {
    Contact contact;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    RandomAccessFile raf;
    int size;
    FileManage() {
    try{
        oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("contacts", true)));
        //raf = new RandomAccessFile("contacts", "rw");
    } 
    catch(IOException e) {}
    
    }
    
    public void addToFile(Contact contact) {
        try {
            //FileOutputStream fos = 
            //oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("contacts", true)));
            oos.writeObject(contact);
            //oos.flush();
            //oos.close();
            oos.reset();
            size++;
        }
        catch(IOException ex) {  // | ClassNotFoundException 
            ex.printStackTrace();
            System.out.println(" io exception in filewrite");
        } 
    }
    
    public ArrayList<Contact> readFromFile() {
        ArrayList<Contact> contacts = new ArrayList();
        try {
            FileInputStream fis = new FileInputStream("contacts");
            ois = new ObjectInputStream(new BufferedInputStream(fis));
            int i = 0;
            while (i <= size){
              //ois = new ObjectInputStream(new BufferedInputStream(fis));
                contact = (Contact)ois.readObject();
                contacts.add(contact);
                //fis.getChannel();
                i++;
            }
            //ois.close();
            
        }
        catch (FileNotFoundException e) {System.out.println("File not found exception in read");} 
        catch (StreamCorruptedException e){System.out.println("StreamCorrupted Exception in read");}        
        catch(ClassNotFoundException e) {System.out.println("Class Not Found Exception in read");}
        catch (IOException ex) {}//ex.printStackTrace(); System.out.println(" IOException in readfromfile");}
        finally{System.out.println("size" + contacts.size());}
        
        return contacts;
            
    }
    
    public void closeOos() {
        try{
            oos.close();
        }
        catch(IOException e){System.out.println(e.getMessage() + e.getStackTrace()  + " oos close error");}
    }
}
