package Lesson4.demo;

import Lesson4.controller.RoomController;
import Lesson4.model.Filter;

public class RoomDemo {
    public static void main(String[] args) {
        RoomController roomController = new RoomController();
        Filter filter = new Filter();
        filter.setNumbersOfGuests(1);
        filter.setPrice(100);
        filter.setBreakfastIncluded(true);
        filter.setPetsAllowed(false);

        System.out.println(roomController.findRoom(filter));

    }
}
