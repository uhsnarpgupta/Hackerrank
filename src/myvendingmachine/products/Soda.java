package myvendingmachine.products;

public class Soda implements Product {
    int price = 45;
    String name = "Soda";

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
