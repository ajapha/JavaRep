package pos;

public class LineItem extends Product {

    private double price;
    private String name;
    private boolean taxable;
    private int quantity;
    private double itemTotal;

    public LineItem(Product p, int quantity) {
        super(p.getPrice(), p.getName(), p.isTaxable());
        this.name = p.getName();
        this.price = p.getPrice();
        this.taxable = p.isTaxable();
        this.quantity = quantity;
        setItemTotal();
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        setItemTotal();
    } 
    
    public int getQuantity() {
        return quantity;
    }

    public double getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(){
        itemTotal = quantity * price;
        double format = itemTotal * 100;
        int formatInt = (int) format;
        itemTotal = formatInt / 100.0;
        
    }
}
