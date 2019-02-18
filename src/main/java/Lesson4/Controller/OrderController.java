package Lesson4.Controller;

import Lesson4.Service.OrderService;

public class OrderController extends OrderService {

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        book_Room(roomId, userId, hotelId);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        cancel_Reservation(roomId, userId);
    }
}
