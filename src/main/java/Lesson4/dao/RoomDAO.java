package Lesson4.dao;

import Lesson4.model.Filter;
import Lesson4.model.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RoomDAO extends GeneralDAO<Room> {

    private String SQL_QUERY_FILTER = "FROM ROOM " +
            "JOIN Hotel ON HOTEL_ID = ?" +
            "WHERE numbersOfGuests =:numberOfGuests" +
            "AND price =:price" +
            "AND breakfastIncluded =:breacfastIncluded" +
            "AND petsAllowed =:petsAllowed" +
            "AND dateAvailableFrom =:dateFrom" +
            "AND hotel =:hotel";

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

    public RoomDAO() {
        setClass(Room.class);
    }

    protected Room saveRoom(Room room) {
        return save(room);
    }

    protected void deleteRoom(long id) {
        delete(id);
    }

    public Room updateRoom(Room room) {
        return update(room);
    }

    public Room findRoomById(long id) throws Exception {
        return findById(id);
    }
}
