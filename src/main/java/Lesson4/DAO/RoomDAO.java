package Lesson4.DAO;

import Lesson4.model.Filter;
import Lesson4.model.Hotel;
import Lesson4.model.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RoomDAO extends GeneralDAO<Room> {

    public RoomDAO() {
        setClass(Room.class);
    }
    private SessionFactory sessionFactory;



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

    private boolean confirmedRoom(Filter filter, Room room) {
        if (filter.getNumbersOfGuests() != 0 && filter.getNumbersOfGuests() != room.getNumbersOfGuests()) {
            return false;
        } else
        if (filter.getPrice() != 0 && filter.getPrice() != room.getPrice()) {
            return false;
        } else
        if (filter.isBreakfastIncluded() != room.isBreakfastIncluded()) {
            return false;
        } else
        if (filter.isPetsAllowed() != room.isPetsAllowed()) {
            return false;
        } else
        if (filter.getDateAvailableFrom() != null && filter.getDateAvailableFrom() != room.getDateAvailableFrom()) {
            return false;
        } else
        if (filter.getHotel() != null && filter.getHotel() != room.getHotel()){
        return false;
        }
        return true;
    }

    public SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

}
