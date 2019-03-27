package myvendingmachine.products;

public class Candy implements Product {
    int price = 10;
    String name = "Candy";

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
