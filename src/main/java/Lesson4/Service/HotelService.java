package Lesson4.Service;

import Lesson4.DAO.HotelDAO;
import Lesson4.model.Hotel;

import java.util.List;

public class HotelService extends HotelDAO {

    protected Hotel findHotelByNameServ(String name){
        return findHotelBy_Name(name);
    }

    protected List<Hotel> findHotelsByCityServ(String city){
        return findHotelsByCity(city);
    }
}
