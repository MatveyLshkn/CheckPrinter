package Product;

public class Product implements Item {
    private int id;
    private double price;
    private String name;
    private boolean hasDiscount;

    public Product(int id, double price, String name, boolean hasDiscount) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.hasDiscount = hasDiscount;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean hasDiscount() {
        return hasDiscount;
    }

}
