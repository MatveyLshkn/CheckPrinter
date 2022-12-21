import Card.Card;
import Product.ProductInCart;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class CheckPrinter {
    private File check = new File("check.txt");
    private FileWriter fileWriter = new FileWriter(check);
    private PrintWriter printer = new PrintWriter(fileWriter);

    private DecimalFormat formatter = new DecimalFormat("0.00");
    private Calendar calendar = new GregorianCalendar();

    public CheckPrinter() throws IOException {
    }


    public void print(ArrayList<ProductInCart> cartItemCart, Card card) {
        if (cartItemCart.size() > 0) {
            printStart();
            double total = 0;
            for (ProductInCart productInCart : cartItemCart) {
                if (productInCart.hasDiscount() && productInCart.getQuantity() >= 5) {
                    double fullPrice = productInCart.getPrice() * productInCart.getQuantity() * 0.9;
                    printer.printf("%-3d%14s%14s%7s%12s%n", productInCart.getQuantity(), productInCart.getName(), "10% discount", "$" + formatter.format(productInCart.getPrice()), "$" + formatter.format(fullPrice));
                    total += fullPrice;
                    continue;
                }
                printer.printf("%-3d%14s%21s%12s%n", productInCart.getQuantity(), productInCart.getName(), "$" + formatter.format(productInCart.getPrice()), "$" + formatter.format(productInCart.getPrice() * productInCart.getQuantity()));
                total += (productInCart.getPrice() * productInCart.getQuantity());

            }
            printFinish(card, total);
        } else {
            printer.print("An error occurred, check console for more info");
        }
        printer.close();

    }

    public void printStart() {
        printer.println("                CASH RECEIPT\n" +
                        "               Supermarket 123\n" +
                        "          12, Milkyway Galaxy/ Earth\n" +
                        "              Tel :123-456-7890\n" +
                        "Cashier #1520        " + "             Date: " + new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()) + "\n" +
                        "                                  Time: " + new SimpleDateFormat("HH:mm:ss").format(calendar.getTime()) + "\n" +
                        "--------------------------------------------------\n" +
                        "Qty   Description                Price       Total");
    }

    public void printFinish(Card card, double total) {
        printer.println("==================================================");
        if (card != null) {
            printer.printf("Discount: %s%37s%n", "%" + card.getDiscount(), "$" + formatter.format(total * card.getDiscount() / 100.00));
        }
        printer.printf("TOTAL%45s%n", "$" + formatter.format(total * (card == null ? 1 : (1.00 - (card.getDiscount() / 100.00)))));
    }
}
