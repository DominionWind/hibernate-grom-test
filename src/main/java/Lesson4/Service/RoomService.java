package Lesson4.Service;

import Lesson4.DAO.RoomDAO;
import Lesson4.model.Filter;
import Lesson4.model.Hotel;
import Lesson4.model.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RoomService extends RoomDAO {

    private SessionFactory sessionFactory;

    public List<Room> findRooms(Filter filter) {
        try {
            Session session = createSessionFactory().openSession();
            return (List<Hotel>) session.createQuery("FROM ROOM WHERE ROOM =:roomParam")
                    .setParameter("roomParam", room).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Error!!! Can`t find Room by filter " + filter.toString());
        }
        sessionFactory.close();
        System.out.println("Can`t find any rooms by city ");
        return null;
    }

    public SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }


}
