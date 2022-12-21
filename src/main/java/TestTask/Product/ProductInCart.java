package Product;

public class ProductInCart implements Item {
    private int quantity;
    protected final Item item;

    public ProductInCart(Item item) {
        this.item = item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void setId(int id) {
        item.setId(id);
    }

    @Override
    public void setPrice(double price) {
        item.setPrice(price);
    }

    @Override
    public void setName(String name) {
        item.setName(name);
    }

    @Override
    public void setHasDiscount(boolean hasDiscount) {
        item.setHasDiscount(hasDiscount);
    }

    @Override
    public int getId() {
        return item.getId();
    }

    @Override
    public double getPrice() {
        return item.getPrice();
    }

    @Override
    public String getName() {
        return item.getName();
    }

    @Override
    public boolean hasDiscount() {
        return item.hasDiscount();
    }

    public int getQuantity() {
        return quantity;
    }
}
