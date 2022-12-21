import Card.CardCreator;
import Card.CardCreatorImpl;
import Product.ItemCreator;
import Product.ItemCreatorImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputFileProcessor {
    private Scanner scanner;
    private Lists lists = new Lists();
    private ItemCreator itemCreator = new ItemCreatorImpl();
    private CardCreator cardCreator = new CardCreatorImpl();

    /**
     * Retrieves data about available cards and items
     * Adds this data to lists in Lists.java
     *
     * @param fileNames file names with info about cards and items
     */
    public void processFiles(ArrayList<String> fileNames) {
        try {
            processCards(fileNames.get(0));
            processItems(fileNames.get(1));
        } catch (Exception e) {
            System.out.println("Some of files are not found");
        }
    }

    /**
     * Processes info about available cards and adds them into cardList in Lists.java
     *
     * @param cardsFileName name of the file which has info about available cards
     */
    public void processCards(String cardsFileName) throws FileNotFoundException {
        File cardsFile = new File(cardsFileName);
        String line;
        scanner = new Scanner(cardsFile);
        while (scanner.hasNextLine()) {
            line = scanner.nextLine().replace(" ","");
            lists.addCard(
                    cardCreator.cardName(line.split(",")[0])
                            .cardDiscount(Integer.parseInt(line.split(",")[1]))
                            .createCard()
            );
        }
    }

    /**
     * Processes info about available items and adds them into itemList in Lists.java
     *
     * @param itemsFileName name of the file which has info about available items
     */
    public void processItems(String itemsFileName) throws FileNotFoundException {
        File itemsFile = new File(itemsFileName);
        String[] params;
        scanner = new Scanner(itemsFile);
        while (scanner.hasNextLine()) {
            params = scanner.nextLine().replace(" ","").split(",");
            lists.addItem(
                    itemCreator.itemId(Integer.parseInt(params[0]))
                            .itemPrice(Double.parseDouble(params[1]))
                            .itemName(params[2])
                            .itemHasDiscount(Boolean.parseBoolean(params[3]))
                            .createItem());
        }
    }
}
