package Lesson4.controller;

import Lesson4.service.HotelService;
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
