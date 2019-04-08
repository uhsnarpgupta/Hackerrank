package oldparkinglot;

public class Bus extends Vehicle {
    public Bus() {
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }

    /* Checks if the spot is a Large. Doesn't check
     num of spots */
    @Override
    public boolean canFitinSpot(ParkingSpot spot) {
        return spot.canFitVehicle(this);
    }

}
