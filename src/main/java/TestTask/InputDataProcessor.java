import Card.Card;
import Product.ProductInCart;

import java.util.ArrayList;
import java.util.Arrays;

public class InputDataProcessor {
    private Lists lists = new Lists();
    private Card card;
    private ArrayList<ProductInCart> cartItemCart;
    private ArrayList<String> fileNames; // names of files with data about products and discount cards
    private InputFileProcessor fileProcessor = new InputFileProcessor(); // class to retrieve Items and cards

    InputDataProcessor(String[] args) {
        processArgs(new ArrayList<>(Arrays.asList(args)));
    }

    /**
     * This method retrieves all necessary data to print the check and calls CheckPrinter
     *
     * @param args initial list of arguments
     */
    private void processArgs(ArrayList<String> args) {
        fileNames = getFileNames(args);
        fileProcessor.processFiles(fileNames);
        card = getCard(args);
        cartItemCart = getItemCart(args);
        try {
            CheckPrinter checkPrinter = new CheckPrinter();
            checkPrinter.print(cartItemCart, card);
        } catch (Exception e) {
            System.out.println("Error");
        }

    }

    /**
     * This method retrieves discount card from list of arguments
     *
     * @param args initial list of arguments
     */
    public Card getCard(ArrayList<String> args) {
        for (String s : args) {
            for (Card card : lists.getCardList()) {
                if (s.equals(card.getName())) {
                    return card;
                }
            }
        }
        System.out.println("No card found");
        return null;
    }

    /**
     * Get list of items from input arguments
     *
     * @param args initial list of arguments
     */
    public ArrayList<ProductInCart> getItemCart(ArrayList<String> args) {
        ArrayList<ProductInCart> productsInCart = new ArrayList<>();
        if (args.size() > 0) {
            args.remove(0);// we remove input file names with data about items and discount cards
            args.remove(0);
            if (args.get(args.size() - 1).toLowerCase().contains("card"))
                args.remove(args.size() - 1);// remove buyers card
            int id = 0;
            int quantity = 0;
            for (String argument : args) {
                try {
                    id = Integer.parseInt(argument.split("-")[0].trim());
                    quantity = Integer.parseInt(argument.split("-")[1].trim());
                    ProductInCart cartItem = new ProductInCart(lists.getItemById(id));
                    cartItem.setQuantity(quantity);
                    productsInCart.add(cartItem);
                } catch (IndexOutOfBoundsException e) {
                    if (id <= 0 || id > lists.getCardList().size()) {
                        System.out.printf("Items.Item with id = %s doesn't exist", id);
                    } else if (quantity <= 0) {
                        System.out.println("The quantity is specified incorrectly");
                    }
                    continue;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid cart input: check your list of arguments");
                    e.printStackTrace();
                    continue;
                }
            }
        }
        return productsInCart;
    }

    /**
     * returns file names with data about available items and cards
     */
    public ArrayList<String> getFileNames(ArrayList<String> items) {
        try {
            return new ArrayList() {{
                add(items.get(0));
                add(items.get(1));
            }};
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Error, wrong input: maybe you have an empty argument list");
            return null;
        }
    }
}
