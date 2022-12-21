import Product.ProductInCart;
import Product.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {// here we test Product.java and ProductInCart.java
    private ProductInCart cartItem1 = new ProductInCart(new Product(1, 6.00, "Orange", false));

    private ProductInCart cartItem2 = new ProductInCart(new Product(2, 8.99, "Apple", true));


    @Test
    void getId() {
        assertEquals(1, cartItem1.getId());
        assertEquals(2, cartItem2.getId());

    }

    @Test
    void getPrice() {
        assertEquals(6.00, cartItem1.getPrice());
        assertEquals(8.99, cartItem2.getPrice());
    }

    @Test
    void getName() {
        assertEquals("Orange", cartItem1.getName());
        assertEquals("Apple", cartItem2.getName());
    }

    @Test
    void hasDiscount() {
        assertEquals(false, cartItem1.hasDiscount());
        assertEquals(true, cartItem2.hasDiscount());
    }

    @Test
    void getQuantity() {
        cartItem1.setQuantity(1);
        cartItem2.setQuantity(2);
        assertEquals(1, cartItem1.getQuantity());
        assertEquals(2, cartItem2.getQuantity());
    }

    @Test
    void setId() {
        cartItem1.setId(3);
        cartItem2.setId(4);
        assertEquals(3, cartItem1.getId());
        assertEquals(4, cartItem2.getId());
    }

    @Test
    void setPrice() {
        cartItem1.setPrice(6.99);
        cartItem2.setPrice(9.00);
        assertEquals(6.99, cartItem1.getPrice());
        assertEquals(9.00, cartItem2.getPrice());
    }

    @Test
    void setName() {
        cartItem1.setName("Water");
        cartItem2.setName("Pepper");
        assertEquals("Water", cartItem1.getName());
        assertEquals("Pepper", cartItem2.getName());
    }

    @Test
    void setHasDiscount() {
        cartItem1.setHasDiscount(true);
        cartItem2.setHasDiscount(false);
        assertEquals(true, cartItem1.hasDiscount());
        assertEquals(false, cartItem2.hasDiscount());
    }

    @Test
    void setQuantity() {
        cartItem1.setQuantity(3);
        cartItem2.setQuantity(4);
        assertEquals(3, cartItem1.getQuantity());
        assertEquals(4, cartItem2.getQuantity());
    }
}