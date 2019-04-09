package Lesson4.controller;

import Lesson4.service.RoomService;
import Lesson4.model.Filter;
import Lesson4.model.Room;

import java.util.List;

public class RoomController{

    RoomService roomService = new RoomService();

    public List<Room> findRoom(Filter filter){
        return roomService.findDooms(filter);
    }

}
