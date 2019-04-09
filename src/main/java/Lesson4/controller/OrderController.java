package Lesson4.controller;

import Lesson4.service.OrderService;

public class OrderController{

    private OrderService orderService = new OrderService();

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        orderService.book_Room(roomId, userId, hotelId);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        orderService.cancel_Reservation(roomId, userId);
    }
}
