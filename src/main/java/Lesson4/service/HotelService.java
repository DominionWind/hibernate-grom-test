package Lesson4.service;

import Lesson4.dao.HotelDAO;
import Lesson4.model.Hotel;

import java.util.List;

public class HotelService{

    HotelDAO hotelDAO = new HotelDAO();

    public List<Hotel> findHotelByName(String name){
        return hotelDAO.findHotelsBy_Name(name);
    }

    public List<Hotel> findHotelsByCity(String city){
        return hotelDAO.findHotelsByCity(city);
    }
}
