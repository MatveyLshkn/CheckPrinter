import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InputDataProcessorTest {

    private String args1[] = new String[]{"cards.txt", "items.txt", "2-5", "3-7", "1-6", "card-1"};
    private String args2[] = new String[]{"cards.txt", "items.txt", "2-5", "3-7", "1-6"};
    private InputDataProcessor inputDataProcessor;
    @Test
    void getCard() {//files should exist
        inputDataProcessor = new InputDataProcessor(args1);
        assertEquals("card-1", inputDataProcessor.getCard(new ArrayList(Arrays.asList(args1))).getName());
        inputDataProcessor = new InputDataProcessor(args2);
        assertEquals(null, inputDataProcessor.getCard(new ArrayList(Arrays.asList(args2))));
    }

    @Test
    void getItemCart() {
        inputDataProcessor = new InputDataProcessor(args1);
        assertNotNull(inputDataProcessor.getItemCart(new ArrayList(Arrays.asList(args1))));
        assertEquals(new ArrayList(), inputDataProcessor.getItemCart(new ArrayList()));
    }

    @Test
    void getFileNames() {
        inputDataProcessor = new InputDataProcessor(args1);
        ArrayList list = inputDataProcessor.getFileNames(new ArrayList(Arrays.asList(args1)));
        assertEquals(args1[0],list.get(0));
        assertEquals(args1[1],list.get(1));
    }
}