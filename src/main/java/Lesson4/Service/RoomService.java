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

    private String SQL_QUERY_FILTER = "FROM ROOM " +
            "JOIN HOTEL ON HOTEL_ID = ?" +
            "WHERE NUMBER_OF_GUESTS =:numberOfGuests" +
            "AND PRICE =:price" +
            "AND BREAKFAST_INCLUDED =:breacfastIncluded" +
            "AND PETS_ALLOWED =:petsAllowed" +
            "AND DATE_FROM =:dateFrom" +
            "AND HOTEL =:hotel";

    private SessionFactory sessionFactory;

    public List<Room> findRooms(Filter filter) {
        try {
            Session session = createSessionFactory().openSession();
            return (List<Room>) session.createQuery(SQL_QUERY_FILTER)
                    .setParameter("numberOfGuests", filter.getNumbersOfGuests())
                    .setParameter("price", filter.getPrice())
                    .setParameter("breacfastIncluded", filter.isBreakfastIncluded())
                    .setParameter("petsAllowed", filter.isPetsAllowed())
                    .setParameter("dateFrom", filter.getDateAvailableFrom())
                    .setParameter("hotel", filter.getHotel()).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Error!!! Can`t find Room by filter " + filter.toString());
        }
        sessionFactory.close();
        System.out.println("Can`t find any rooms by city ");
        return null;
    }

//    private int numbersOfGuests;
//    private double price;
//    private boolean breakfastIncluded;
//    private boolean petsAllowed;
//    private Date dateAvailableFrom;
//    private Hotel hotel;

    public SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }


}
