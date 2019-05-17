package parkingLot;

public abstract class ParkingSpot {
    private String number;
    private boolean free;
    private Vehicle vehicle;
    private final ParkingSpotType type;

    public abstract boolean IsFree();

    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        free = false;
        return free;
    }

    public boolean removeVehicle() {
        this.vehicle = null;
        free = true;
        return free;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public boolean isFree() {
        return free;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
