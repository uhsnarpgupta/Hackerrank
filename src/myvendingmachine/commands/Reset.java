package myvendingmachine.commands;

import myvendingmachine.products.Product;

public class Reset implements Command {
    Product product;

    public Reset(Product product) {
        this.product = product;
    }

    @Override
    public void execute() {
        System.out.println(product.getName() + " deleted from cart");
    }
}
