package Lesson4.Controller;

import Lesson4.Service.HotelService;
import Lesson4.model.Hotel;

import java.util.List;

public class HotelController extends HotelService {

    public List<Hotel> findHotelByName(String hotelName){
        return findHotelByNameServ(hotelName);
    }

    public List<Hotel> findHotelByCity(String city){
        return findHotelsByCityServ(city);
    }
}
