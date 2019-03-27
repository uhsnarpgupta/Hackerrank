package myvendingmachine.commands;

import myvendingmachine.products.Product;

public class Refund implements Command {
    Product product;

    public Refund(Product product) {
        this.product = product;
    }

    @Override
    public void execute() {
        int productPrice = product.getPrice();
        System.out.println("Collect refund for " + product.getName() + " with change of " + productPrice + " units");

    }
}
