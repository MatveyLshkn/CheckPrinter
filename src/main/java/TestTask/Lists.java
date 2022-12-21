import Card.Card;
import Product.Product;

import java.util.ArrayList;

public class Lists {//here you can find lists with stored info about available cards an items
    private static ArrayList<Card> cardList = new ArrayList();
    private static ArrayList<Product> productList = new ArrayList<>();
    public void setCardList(ArrayList<Card> cardList){
        Lists.cardList = cardList;
    }

    public void setItemList(ArrayList<Product> productList) {
        Lists.productList = productList;
    }

    public ArrayList<Card> getCardList() {
        return cardList;
    }

    public static ArrayList<Product> getItemList() {
        return productList;
    }

    public Product getItemById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) return product;
        }
        return null;
    }

    public void addItem(Product product) {
        productList.add(product);
    }

    public void addCard(Card card) {
        cardList.add(card);
    }
}
