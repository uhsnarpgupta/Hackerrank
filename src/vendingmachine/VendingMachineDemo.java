package vendingmachine;

import vendingmachine.constants.Item;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class VendingMachineDemo {
    public static void main(String args[]) throws IOException {
        VendingMachine vMachine = new VendingMachineImpl();
        Scanner sc = new Scanner(System.in);

        System.out.println("\t\t\tWelcome to Vending Machine.");
        System.out.println("Put coins in the denomination of: 1,5,10,25,50,100,200");
        int coins = sc.nextInt();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int choice = 8;
        do {
            System.out.println("Select one of the Items: \n");
            System.out.println("1.CANDY(10)");
            System.out.println("2.SNACK(50)");
            System.out.println("3.NUTS(90)");
            System.out.println("4.COKE(25)");
            System.out.println("5.PEPSI(35)");
            System.out.println("6.SODA(45)");
            System.out.println("7.CANCEL");
            System.out.println("8.RESET");
            System.out.println("9.EXIT");
            choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
            }
        } while (choice != 9);

        long nutsPrice = vMachine.selectItemAndGetPrice(Item.NUTS);
        System.out.println();

    }
}
