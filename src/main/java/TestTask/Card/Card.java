package Card;

public class Card {
    private  String name;
    private int discount;
    public Card(String name, int discount){
        this.name = name;
        this.discount = discount;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public int getDiscount() {
        return discount;
    }
}
