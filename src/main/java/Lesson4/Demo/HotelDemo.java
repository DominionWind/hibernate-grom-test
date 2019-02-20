package Lesson4.Demo;

import Lesson4.Controller.HotelController;

public class HotelDemo {
    public static void main(String[] args) {

        HotelController hotelController = new HotelController();

        System.out.println(hotelController.findHotelByCity("city"));

//        System.out.println(hotelController.findHotelByName("hotel_1"));
    }
}
