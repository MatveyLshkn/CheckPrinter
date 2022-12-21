import Card.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    private Card card = new Card("TestCard-1", 15);

    @Test
    void getName() {
        assertEquals("TestCard-1", card.getName());
    }

    @Test
    void getDiscount() {
        assertEquals(15, card.getDiscount());
    }

    @Test
    void setName() {
        card.setName("TestName");
        assertEquals("TestName", card.getName());
    }

    @Test
    void setDiscount() {
        card.setDiscount(30);
        assertEquals(30, card.getDiscount());
    }
}