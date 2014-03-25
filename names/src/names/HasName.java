package names;

public class HasName implements Nameable {
    private String name;
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    } 
}
