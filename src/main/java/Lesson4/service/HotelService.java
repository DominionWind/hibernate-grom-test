package Lesson4.service;

import Lesson4.dao.HotelDAO;
import Lesson4.model.Hotel;

import java.util.List;

public class HotelService extends HotelDAO {

    protected List<Hotel> findHotelByNameServ(String name){
        return findHotelsBy_Name(name);
    }

    protected List<Hotel> findHotelsByCityServ(String city){
        return findHotelsByCity(city);
    }
}
