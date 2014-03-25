package pos;

public class Product {
    private double price;
    private String name;
    private boolean taxable;

    public Product(double price, String name, boolean taxable) {
        this.price = price;
        this.name = name;
        this.taxable = taxable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public String Taxable() {
        if(taxable) {
            return "t";
        }
        return "f";
    }
    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

}