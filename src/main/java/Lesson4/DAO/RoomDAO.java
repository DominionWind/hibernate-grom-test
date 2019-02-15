package Lesson4.DAO;

import Lesson4.model.Filter;
import Lesson4.model.Room;

import java.util.List;

public class RoomDAO extends GeneralDAO {

    public RoomDAO() {
        setClass(Room.class);
    }

    public List<Room> findRooms(Filter filter) {

        return null;
    }

    protected Room saveRoom(Room room) {
        return (Room) save(room);
    }

    protected void deleteRoom(long id) {
        delete(id);
    }

    protected Room updateRoom(Room room) {
        return (Room) update(room);
    }

    protected Room findRoomById(long id) throws Exception {
        return (Room) findById(id);
    }

}
