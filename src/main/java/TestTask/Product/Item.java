package Product;

public interface Item {
    void setId(int id);

    void setPrice(double price);

    void setName(String name);

    void setHasDiscount(boolean hasDiscount);

    int getId();

    double getPrice();

    String getName();

    boolean hasDiscount();
}
