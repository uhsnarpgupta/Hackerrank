package oldparkinglot;

public class Car extends Vehicle {
    public Car() {
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }

    /* Checks if the spot is a Large. Doesn't check
     num of spots */
    @Override
    public boolean canFitinSpot(ParkingSpot spot) {
        return spot.canFitVehicle(this);
    }

}
