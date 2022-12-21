import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InputFileProcessorTest {
    private Lists lists = new Lists();
    private InputFileProcessor inputFileProcessor = new InputFileProcessor();

    /*
     * To pass tests you must have files with data about cards and items
     * */
    @BeforeEach
    void nuller() {
        lists.setCardList(new ArrayList<>());
        lists.setItemList(new ArrayList<>());
    }

    @Test
    void processCards() {
        //let's say we have file named cards.txt with data about 2 cards
        try {
            inputFileProcessor.processCards("cards.txt");
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }
        assertEquals(2, lists.getCardList().size());
    }

    @Test
    void processItems() {
        //let's say we have file named items.txt with data about 3 items
        try {
            inputFileProcessor.processItems("items.txt");
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }
        assertEquals(3, lists.getItemList().size());
    }
}
