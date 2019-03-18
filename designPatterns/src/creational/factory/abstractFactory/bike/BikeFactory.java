package creational.factory.abstractFactory.bike;

public abstract class BikeFactory {
    abstract BikePart create(String type);
}
