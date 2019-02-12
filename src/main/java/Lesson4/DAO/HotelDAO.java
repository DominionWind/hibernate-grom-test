package Lesson4.DAO;

import Lesson4.model.Hotel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class HotelDAO extends GeneralDAO{

    private SessionFactory sessionFactory;

    public Hotel findHotelByName(String name){
        Session session = null;
        Transaction tr = null;
        Hotel hotel = new Hotel();
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            hotel = session.get(Hotel.class, "name");
            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Can`t find hotel with name " + name);
            System.err.println(e.getMessage());

            if (tr != null) {
                tr.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        sessionFactory.close();
        System.out.println("Done");
        return hotel;
    }

    public List<Hotel> findHotelsByCity(String city){
        try{
            Session session = createSessionFactory().openSession();
            return (List<Hotel>) session.createQuery("FROM HOTEL WHERE CITY =:hotelCity")
                    .setParameter("hotelCity", city).list();
        } catch (HibernateException e){
            e.printStackTrace();
            System.err.println("Can`t find Hotel by city " + city);
        }
        sessionFactory.close();
        return null;
    }

    public SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
