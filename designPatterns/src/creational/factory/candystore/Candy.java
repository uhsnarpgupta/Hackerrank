package creational.factory.candystore;

import java.util.ArrayList;

public abstract class Candy {
    abstract ArrayList<Candy> makeCandyPackage(int quantity);
}
