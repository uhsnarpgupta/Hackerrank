package oldparkinglot;

public class Motorcycle extends Vehicle {
    public Motorcycle() {
        spotsNeeded = 1;
        size = VehicleSize.Motorcycle;
    }

    /* Checks if the spot is a Large. Doesn't check
     num of spots */
    @Override
    public boolean canFitinSpot(ParkingSpot spot) {
        return spot.canFitVehicle(this);
    }

}
