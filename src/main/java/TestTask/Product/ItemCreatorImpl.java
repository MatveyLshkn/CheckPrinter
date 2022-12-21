package Product;

public class ItemCreatorImpl implements ItemCreator {
    private int id;
    private double price;
    private String name;
    private boolean hasDiscount;

    @Override
    public ItemCreator itemId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public ItemCreator itemPrice(double price) {
        this.price = price;
        return this;
    }

    @Override
    public ItemCreator itemName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ItemCreator itemHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
        return this;
    }

    @Override
    public Product createItem() {
        Product product = new Product(id, price, name, hasDiscount);
        return product;
    }
}
