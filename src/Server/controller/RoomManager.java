package Server.controller;

import java.util.ArrayList;

import Shared.helper.RandomString;

public class RoomManager {

    ArrayList<Room> rooms;
    RandomString idGenerator;

    public RoomManager() {
        rooms = new ArrayList<>();
        idGenerator = new RandomString(5);
    }

    public Room createRoom() {
        Room room = new Room(idGenerator.nextString());
        rooms.add(room);

        return room;
    }

    public boolean add(Room r) {
        if (!rooms.contains(r)) {
            rooms.add(r);
            return true;
        }
        return true;
    }

    public boolean remove(Room r) {
        if (rooms.contains(r)) {
            rooms.remove(r);
            return true;
        }
        return false;
    }

    public Room find(String id) {
        for (Room r : rooms) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    public int getSize() {
        return rooms.size();
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
}
