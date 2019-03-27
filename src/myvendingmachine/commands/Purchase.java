package myvendingmachine.commands;

import myvendingmachine.products.Product;

public class Purchase implements Command {
    Product product;
    int depositedMoney;

    public Purchase(Product product, int depositedMoney) {
        this.product = product;
        this.depositedMoney = depositedMoney;
    }

    @Override
    public void execute() {
        int productPrice = product.getPrice();
        if (depositedMoney < productPrice) {
            System.out.println("Insuficient funds provided");
        } else {
            int extraMoney = depositedMoney - productPrice;
            System.out.println("Collect " + product.getName() + " with change of " + extraMoney + " units");
        }
    }
}
