package Card;

public interface CardCreator {
    CardCreator cardName(String name);

    CardCreator cardDiscount(int discount);

    Card createCard();
}
