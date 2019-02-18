package Lesson4.Controller;

import Lesson4.Service.RoomService;
import Lesson4.model.Filter;
import Lesson4.model.Room;

import java.util.List;

public class RoomController extends RoomService {

    public List<Room> findRoom(Filter filter){
        return findRooms(filter);
    }

}
