package Lesson4.dao;

import Lesson4.model.Room;

public class RoomDAO extends GeneralDAO<Room> {

    public RoomDAO() {
        setClass(Room.class);
    }

    protected Room saveRoom(Room room) {
        return save(room);
    }

    protected void deleteRoom(long id) {
        delete(id);
    }

    public Room updateRoom(Room room) {
        return update(room);
    }

    public Room findRoomById(long id) throws Exception {
        return findById(id);
    }
}
