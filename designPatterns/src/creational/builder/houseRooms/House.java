package creational.builder.houseRooms;

import java.util.ArrayList;

public class House {
    private ArrayList<Room> rooms;

    public House(ArrayList<Room> rooms) {
        this.rooms = new ArrayList<>(rooms);
    }
}
