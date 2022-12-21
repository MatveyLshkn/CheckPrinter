package Product;

public interface ItemCreator {
    ItemCreator itemId(int id);

    ItemCreator itemPrice(double price);

    ItemCreator itemName(String name);

    ItemCreator itemHasDiscount(boolean hasDiscount);

    Product createItem();
}
