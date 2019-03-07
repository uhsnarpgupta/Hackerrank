package creational.builder.houseRooms;

import java.awt.*;

public class RoomBuilder implements Builder {
    private Dimension dimension;
    private int ceilingHeight;
    private int floorNumber;
    private Color wallColor;
    private int numberOfWindows;
    private int numberOfDoors;
    private boolean isDouble;
    private boolean hasEnsuite;
    private RoomListBuilder roomListBuilder;

    public RoomBuilder() {
    }

    public RoomBuilder(RoomListBuilder roomListBuilder) {
        this.roomListBuilder = roomListBuilder;
    }

    @Override
    public RoomBuilder setDimension(Dimension dimension) {
        this.dimension = dimension;
        return this;
    }

    @Override
    public RoomBuilder setCeilingHeight(int ceilingHeight) {
        this.ceilingHeight = ceilingHeight;
        return this;
    }

    @Override
    public RoomBuilder setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
        return this;
    }

    @Override
    public RoomBuilder setWallColor(Color wallColor) {
        this.wallColor = wallColor;
        return this;
    }

    @Override
    public RoomBuilder setNumberOfWindows(int numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
        return this;
    }

    @Override
    public RoomBuilder setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
        return this;
    }

    public RoomBuilder setIsDouble(boolean isDouble) {
        this.isDouble = isDouble;
        return this;
    }

    public RoomBuilder setHasEnsuite(boolean hasEnsuite) {
        this.hasEnsuite = hasEnsuite;
        return this;
    }

    public Room createRoom() {
        return new Room(dimension, ceilingHeight, floorNumber, wallColor, numberOfWindows, numberOfDoors, isDouble, hasEnsuite);
    }

    public RoomListBuilder addRoomToList() {
        Room room = createRoom();
        this.roomListBuilder.addRoom(room);
        return this.roomListBuilder;
    }
}