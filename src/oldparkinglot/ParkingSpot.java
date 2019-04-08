package oldparkinglot;

public class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int row;
    private int spotNumber;
    private Level level;

    public ParkingSpot(Level lvl, int r, int n,
                       VehicleSize s) {
        this.level = lvl;
        this.row = r;
        this.spotNumber = n;
        this.spotSize = s;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    /* Check if the spot is big enough and is available */
    public boolean canFitVehicle(Vehicle vehicle) {
        return spotSize == vehicle.size;
    }

    /* Park vehicle in this spot. */
    public boolean park(Vehicle v) {
        return false;
    }

    public int getRow() {
        return row;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    /* Remove vehicle from spot, and notify
      level that a new spot is available */
    public void removeVehicle() {

    }
}
