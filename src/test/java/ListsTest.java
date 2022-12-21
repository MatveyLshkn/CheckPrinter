import Card.Card;
import Product.Product;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListsTest {
    private Lists lists = new Lists();
    private ArrayList<Product> testProductList = new ArrayList() {{
        add(new Product(3, 6.00, "Milk", false));//1
        add(new Product(2, 1.99, "Banana", true));//13
    }};
    private ArrayList<Card> testCardList = new ArrayList() {{
        add(new Card("card-3", 15));
        add(new Card("card-4", 30));
    }};

    @BeforeEach
    void nuller() {
        lists.setCardList(new ArrayList<>());
        lists.setItemList(new ArrayList<>());
    }

    @Test
    void addItem() {
        lists.addItem(new Product(1, 6.00, "Orange", false));//1
        lists.addItem(new Product(2, 1.99, "Apple", true));//13
        assertEquals(2, lists.getItemList().size());
    }

    @Test
    void addCard() {
        lists.addCard(new Card("card-1", 15));
        lists.addCard(new Card("card-2", 30));
        assertEquals(2, lists.getCardList().size());
    }

    @Test
    void getCardList() {
        lists.addCard(new Card("card-3", 15));
        lists.addCard(new Card("card-4", 30));
        assertEquals(testCardList.get(0).getDiscount(), lists.getCardList().get(0).getDiscount());
        assertEquals(testCardList.get(1).getDiscount(), lists.getCardList().get(1).getDiscount());
        assertEquals(testCardList.size(), lists.getCardList().size());
    }

    @Test
    void getItemList() {
        lists.addItem(new Product(3, 6.00, "Milk", false));//1
        lists.addItem(new Product(2, 1.99, "Banana", true));//13
        assertEquals(testProductList.get(0).getName(), lists.getItemList().get(0).getName());
        assertEquals(testProductList.get(1).getName(), lists.getItemList().get(1).getName());
        assertEquals(testProductList.size(), lists.getItemList().size());
    }

    @Test
    void getItemById() {
        lists.addItem(new Product(3, 6.00, "Orange", false));//1
        lists.addItem(new Product(1, 1.99, "Apple", true));//13
        assertEquals(lists.getItemList().get(0).getName(), lists.getItemById(3).getName());
        assertEquals(lists.getItemList().get(1).getName(), lists.getItemById(1).getName());
    }
}