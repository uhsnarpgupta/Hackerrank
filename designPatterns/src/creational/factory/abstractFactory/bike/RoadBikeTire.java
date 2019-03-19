package creational.factory.abstractFactory.bike;

public class RoadBikeTire extends Tire {
    private static final String width = "NARROW";
    private static final String pressure = "HIGH";

    @Override
    public void getDescription() {
        System.out.println("Road bike tire width: " + width + ", pressure: " + pressure);
    }
}