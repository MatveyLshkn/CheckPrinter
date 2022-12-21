package Card;


public class CardCreatorImpl implements CardCreator {
    private String name;
    private int discount;

    @Override
    public CardCreator cardName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public CardCreator cardDiscount(int discount) {
        this.discount = discount;
        return this;
    }

    @Override
    public Card createCard() {
        Card card = new Card(name, discount);
        return card;
    }
}
