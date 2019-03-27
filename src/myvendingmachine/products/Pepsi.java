package myvendingmachine.products;

public class Pepsi implements Product {
    int price = 35;
    String name = "Pepsi";

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
