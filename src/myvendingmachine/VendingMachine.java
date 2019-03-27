package myvendingmachine;

import myvendingmachine.commands.Command;
import myvendingmachine.commands.Purchase;
import myvendingmachine.commands.Refund;
import myvendingmachine.commands.Reset;
import myvendingmachine.products.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VendingMachine {
    public static void main(String[] args) throws IOException {
        System.out.println("Select one of the following products: \n" +
                "1: Candy - Rs 10 \n" +
                "2: Snack - Rs 50 \n" +
                "3: Nuts - Rs 90\n" +
                "4: Coke - Rs 25\n" +
                "5: Pepsi - Rs 35\n" +
                "6: Soda - Rs 45\n"
        );
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int option = Integer.parseInt(br.readLine());

        System.out.println("Enter funds: ");
        int funds = Integer.parseInt(br.readLine());

        System.out.println("Select one of the operations: \n" +
                "1: Purchase \n" +
                "2: Refund \n" +
                "3: Reset\n");
        int operation = Integer.parseInt(br.readLine());

        Product product = null;

        switch (option) {
            case 1:
                product = new Candy();
                break;
            case 2:
                product = new Snack();
                break;
            case 3:
                product = new Nuts();
                break;
            case 4:
                product = new Coke();
                break;
            case 5:
                product = new Pepsi();
                break;
            case 6:
                product = new Soda();
                break;
            default:
                System.out.println("Invalid option chosen");
        }

        Command command = null;

        switch (operation) {
            case 1:
                command = new Purchase(product, funds);
                break;
            case 2:
                command = new Refund(product);
                break;
            case 3:
                command = new Reset(product);
                break;
            default:
        }
        if (command != null)
            command.execute();
    }
}
