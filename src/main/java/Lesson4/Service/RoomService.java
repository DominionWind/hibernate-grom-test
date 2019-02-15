package Lesson4.Service;

import Lesson4.DAO.OrderDAO;
import Lesson4.DAO.RoomDAO;
import Lesson4.DAO.UserDAO;
import Lesson4.model.Order;
import Lesson4.model.Room;
import Lesson4.model.User;

import java.util.Date;
import java.util.List;

public class RoomService extends RoomDAO {

    OrderDAO orderDAO = new OrderDAO();
    UserDAO userDAO = new UserDAO();

    protected void book_Room(long roomId, long userId, long HotelId) throws Exception {
        Room room = findRoomById(roomId);
        User user = userDAO.findUserById(userId);
        Order order = new Order();
        order.setUser(user);
        order.setRoom(room);
        Date dateFrom = new Date();
        Date dateTo = new Date();
        order.setDateFrom(dateFrom);
        order.setDateTo(dateTo);
        order.setMoneyPaid(room.getPrice() * (dateFrom.getTime() - dateTo.getTime()));

        orderDAO.saveOrder(order);
        room.setDateAvailableFrom(dateFrom);
    }

    protected void cancel_Reservation(long roomId, long userId) throws Exception {
        //Этот метод я намеренно обрабатываю не в БД. Могу и в БД его сделать.


        // SELECT *
        // FROM ORDER                               Как то так будет выглядеть SQL запрос. со 100% вероятностью пока не умею
        // JOIN ON ORDER.USER_ID=USER.USER_ID
        // JOIN ORDER.ROOM_ID ON ROOM.ROOM_ID.

        User user = userDAO.findUserById(userId);
        Room room = findRoomById(roomId);

        List<Order> orders = user.getOrders();

        for (Order order : orders) {
            if (order.getRoom().getId() == roomId) {
                orderDAO.deleteOrder(order.getId());
                room.setDateAvailableFrom(new Date());
                updateRoom(room);
            }
        }
    }
}
