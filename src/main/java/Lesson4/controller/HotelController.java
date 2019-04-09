package Lesson4.controller;

import Lesson4.service.HotelService;
import Lesson4.model.Hotel;

import java.util.List;

public class HotelController{

    private HotelService hotelService = new HotelService();

    public List<Hotel> findHotelByName(String hotelName){
        return hotelService.findHotelByName(hotelName);
    }

    public List<Hotel> findHotelByCity(String city){
        return hotelService.findHotelsByCity(city);
    }
}
