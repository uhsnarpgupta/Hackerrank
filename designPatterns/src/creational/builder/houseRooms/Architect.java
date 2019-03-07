package creational.builder.houseRooms;

import java.awt.*;
import java.util.ArrayList;

public class Architect {
    public static void main(String[] args) {
        Room bedRoom = new RoomBuilder()
                .setDimension(new Dimension(200, 100))
                .setCeilingHeight(132)
                .setFloorNumber(1)
                .createRoom();

        Room kitchen = new RoomBuilder()
                .setDimension(new Dimension(300, 100))
                .setCeilingHeight(132)
                .setFloorNumber(2)
                .createRoom();

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(bedRoom);
        rooms.add(kitchen);

        House house = new House(rooms);

        ArrayList<Room> rooms2 = new RoomListBuilder().addList()
                .addRoom().setFloorNumber(2).setCeilingHeight(212).setNumberOfWindows(2).addRoomToList()
                .addRoom().setFloorNumber(2).setCeilingHeight(212).setNumberOfWindows(2).addRoomToList()
                .buildList();

        House house2 = new House(rooms2);


    }
}
