package oldparkinglot;

public class Level {
    private int floor;
    private ParkingSpot[] parkingSpots;
    private int availableSpots = 0;
    private static final int SPOTS_PER_ROW = 10;


    public Level(int floor, int availableSpots) {
        this.floor = floor;
        this.availableSpots = availableSpots;
    }

    public int availableSpots() {
        return availableSpots;
    }

    /* Find a place to park this vehicle. Return false if failed. */
    public boolean parkVehicle(Vehicle vehicle) {
        return false;
    }


    /* Park a vehicle starting at the spot spotNumber, and
     * continuing until vehicle.spotsNeeded.*/

    private boolean parkStartingAtSpot(int num, Vehicle v) {
        return false;
    }

    /* Find a spot to park this vehicle. Return index of spot, or -1 on failure*/
    private int findAvailableSpots(Vehicle vehicle) {
        return 0;
    }

    public void spotFreed() {
        availableSpots++;
    }
}
