package Lesson4.demo;

import Lesson4.controller.HotelController;

public class HotelDemo {
    public static void main(String[] args) {

        HotelController hotelController = new HotelController();

//        System.out.println(hotelController.findHotelByCity("city"));

        System.out.println(hotelController.findHotelByName("hotel_1"));
    }
}
