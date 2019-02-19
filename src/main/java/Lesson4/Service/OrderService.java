package Lesson4.Service;

import Lesson4.DAO.OrderDAO;
import Lesson4.DAO.RoomDAO;
import Lesson4.DAO.UserDAO;
import Lesson4.model.Order;
import Lesson4.model.Room;
import Lesson4.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.Date;
import java.util.List;

public class OrderService extends OrderDAO {

    private RoomDAO roomDAO = new RoomDAO();
    private UserDAO userDAO = new UserDAO();


    protected void book_Room(long roomId, long userId, long HotelId) throws Exception {
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

        Session session = null;
        Transaction tr = null;

        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            saveOrder(order);
            roomDAO.updateRoom(room);

            tr.commit();
        } catch (HibernateException e) {

            System.err.println("Transaction is failed");
            System.err.println(e.getMessage());

            if (tr != null) {
                tr.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    protected void cancel_Reservation(long roomId, long userId) throws Exception {
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
                deleteOrder(order.getId());
                room.setDateAvailableFrom(new Date());
                roomDAO.updateRoom(room);
            }
        }
    }
}
