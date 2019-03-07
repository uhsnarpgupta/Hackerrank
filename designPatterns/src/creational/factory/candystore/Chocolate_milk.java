package creational.factory.candystore;

import java.util.ArrayList;

public class Chocolate_milk extends Candy {
    @Override
    ArrayList<Candy> makeCandyPackage(int quantity) {
        ArrayList chocolatePackage = new ArrayList<>();
        for (int i = 1; i <= quantity; i++) {
            Chocolate_milk chocolate = new Chocolate_milk();
            chocolatePackage.add(chocolate);
        }

        System.out.println("One package of " + quantity + " milk chocolates has been made!");
        return chocolatePackage;
    }
}
