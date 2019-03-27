package myvendingmachine.products;

public class Snack implements Product {
    int price = 50;
    String name = "Snack";

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
