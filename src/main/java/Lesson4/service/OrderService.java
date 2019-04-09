package Lesson4.service;

import Lesson4.dao.OrderDAO;
import Lesson4.dao.RoomDAO;
import Lesson4.dao.UserDAO;
import Lesson4.model.Order;
import Lesson4.model.Room;
import Lesson4.model.User;
import org.hibernate.HibernateException;

import java.util.Date;
import java.util.List;

public class OrderService{

    private OrderDAO orderDAO = new OrderDAO();
    private RoomDAO roomDAO = new RoomDAO();
    private UserDAO userDAO = new UserDAO();


    public void book_Room(long roomId, long userId, long HotelId) throws Exception {
        Room room = roomDAO.findRoomById(roomId);
        User user = userDAO.findUserById(userId);
        Order order = new Order();

        order.setUser(user);
        order.setRoom(room);

        Date dateFrom = new Date();
        Date dateTo = new Date();

        order.setDateFrom(dateFrom);
        order.setDateTo(dateTo);

        order.setMoneyPaid(room.getPrice() * (dateFrom.getTime() - dateTo.getTime()));

        room.setDateAvailableFrom(dateFrom);

        try {
            roomDAO.updateRoom(room);
        } catch (HibernateException e) {
            System.err.println("Transaction is failed");
            System.err.println(e.getMessage());
        }
    }

    public void cancel_Reservation(long roomId, long userId) throws Exception {
        //        Этот метод я намеренно обрабатываю не в БД. Могу и в БД его сделать.
        //        SQL Запрос будет выглядеть так.
        //        SELECT * FROM ORDERS
        //        WHERE ROOM_ID = ? AND USER_ID = ?;

        //

        User user = userDAO.findUserById(userId);
        Room room = roomDAO.findRoomById(roomId);

        List<Order> orders = user.getOrders();

        for (Order order : orders) {
            if (order.getRoom().getId() == roomId) {
                orderDAO.deleteOrder(order.getId());
                room.setDateAvailableFrom(new Date());
                roomDAO.updateRoom(room);
            }
        }
    }
}
