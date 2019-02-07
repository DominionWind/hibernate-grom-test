package Lesson2.HQL;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDAO_HQL {

    public SessionFactory sessionFactory;

    public Product findById(long id) {
        try {
            Session session = createSessionFactory().openSession();
            return session.get(Product.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Can`t find Product by Id " + id);
        }
        sessionFactory.close();
        System.out.println("findById Done");
        return null;
    }

    public List<Product> findByName(String name) {
        try {
            Session session = createSessionFactory().openSession();
            return (List<Product>) session.createQuery("FROM Product as products WHERE name = :productName")
                    .setParameter("productName", name).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Can`t find Product by Name " + name);
        }
        sessionFactory.close();
        return null;
    }

    public List<Product> findByContainedName(String name) {
        try {
            Session session = createSessionFactory().openSession();
            return (List<Product>) session.createQuery("FROM Product WHERE name LIKE :productName")
                    .setParameter("productName", name).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Can`t find Product by Name " + name);
        }
        sessionFactory.close();
        return null;
    }

    public List<Product> findByPrice(int price, int delta) {
        try {
            Session session = createSessionFactory().openSession();
            return (List<Product>) session.createQuery("FROM Product WHERE price BETWEEN :minPrice AND :maxPrice")
                    .setParameter("minPrice", price - delta).setParameter("maxPrice", price + delta).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Can`t find Product by price " + price + " with delta " + delta);
        }
        sessionFactory.close();
        return null;
    }

    public List<Product> findByNameSortedAcc(String name) {
        try {
            Session session = createSessionFactory().openSession();
            return (List<Product>) session.createQuery("FROM Product WHERE name LIKE :productName ORDER BY name")
                    .setParameter("productName", name).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Can`t find Products by price " + name + " and sort them ACC");
        }
        sessionFactory.close();
        return null;
    }

    public List<Product> findByNameSortedDec(String name) {
        try {
            Session session = createSessionFactory().openSession();
            return (List<Product>) session.createQuery("FROM Product WHERE name LIKE :productName ORDER BY name DESC ")
                    .setParameter("productName", name).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Can`t find Products by price " + name + " and sort them DEC");
        }
        sessionFactory.close();
        return null;
    }

    public List<Product> findByPriceSortedDec(int price, int delta) {
        try {
            Session session = createSessionFactory().openSession();
            return (List<Product>) session.createQuery("FROM Product WHERE price BETWEEN :minPrice AND :maxPrice ORDER BY price DESC ")
                    .setParameter("minPrice", price - delta).setParameter("maxPrice", price + delta).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Can`t find Products by price " + price + " with delta " + delta + " and sort them DEC");
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
