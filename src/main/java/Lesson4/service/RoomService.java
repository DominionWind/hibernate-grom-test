package Lesson4.service;

import Lesson4.dao.RoomDAO;
import Lesson4.model.Filter;
import Lesson4.model.Room;

import java.util.List;

public class RoomService{

    private RoomDAO roomDAO = new RoomDAO();

    public List<Room> findDooms(Filter filter){
        return roomDAO.findRooms(filter);
    }
}
