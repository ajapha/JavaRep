package names;

public class Names {
    public static void main(String[] args) {
        //Nameable n = new Nameable();
        
        Person p = new Person();
        p.setName("Bob");
        p.setAddress("123 First St");
        
        Organization o = new Organization();
        o.setName("PCS");
        o.setAddress("456 Mossad Dr");
        
        System.out.println(p.getName() + " " + p.getAddress());
        System.out.println(o.getName() + " " +  o.getAddress());
    }
}