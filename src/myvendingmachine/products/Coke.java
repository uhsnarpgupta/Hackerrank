package myvendingmachine.products;

public class Coke implements Product {
    int price = 25;
    String name = "Coke";

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
