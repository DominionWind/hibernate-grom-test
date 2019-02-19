package Lesson4.DAO;

import Lesson4.model.Hotel;
import org.hibernate.HibernateException;
import org.hibernate.Session;


import java.util.List;


public class HotelDAO extends GeneralDAO<Hotel> {

    public HotelDAO() {
        setClass(Hotel.class);
    }


    public List<Hotel> findHotelsBy_Name(String name) {
        try {
            Session session = createSessionFactory().openSession();
            return (List<Hotel>) session.createQuery("FROM HOTEL WHERE NAME =:hotelName")
                    .setParameter("hotelName", name).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Error!!! Can`t find Hotel by name " + name);
        }
        System.out.println("Can`t find Hotel by name " + name);
        return null;
    }

    public List<Hotel> findHotelsByCity(String city) {
        try {
            Session session = createSessionFactory().openSession();
            return (List<Hotel>) session.createQuery("FROM HOTEL WHERE CITY =:hotelCity")
                    .setParameter("hotelCity", city).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Error!!! Can`t find Hotel by city " + city);
        }
        System.out.println("Can`t find Hotel by city " + city);
        return null;
    }

    public Hotel saveHotel(Hotel hotel) {
        return save(hotel);
    }

    public void deleteHotel(long id) {
        delete(id);
    }

    public Hotel updateHotel(Hotel hotel) {
        return update(hotel);
    }

    public Hotel findHotelById(long id) throws Exception {
        return findById(id);
    }
}
