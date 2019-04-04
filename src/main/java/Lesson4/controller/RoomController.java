package Lesson4.controller;

import Lesson4.service.RoomService;
import Lesson4.model.Filter;
import Lesson4.model.Room;

import java.util.List;

public class RoomController extends RoomService {

    public List<Room> findRoom(Filter filter){
        return findRooms(filter);
    }

}
