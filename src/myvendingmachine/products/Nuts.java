package myvendingmachine.products;

public class Nuts implements Product {
    int price = 90;
    String name = "Nuts";

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
