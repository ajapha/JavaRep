package names;

/**
 * @author Aaron Japha
 */
public class HasAddress implements Addressable {

    private String address;
    
    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }
    
    
    
}
