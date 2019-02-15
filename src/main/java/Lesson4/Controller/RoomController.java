package Lesson4.Controller;

import Lesson4.Service.RoomService;
import Lesson4.model.Room;

public class RoomController extends RoomService {

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        book_Room(roomId, userId, hotelId);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        cancel_Reservation(roomId, userId);
    }

}
