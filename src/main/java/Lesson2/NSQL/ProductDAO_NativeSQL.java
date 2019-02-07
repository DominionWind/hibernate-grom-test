package Lesson2.NSQL;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDAO_NativeSQL {

    private SessionFactory sessionFactory;

    private String findById = "SELECT * FROM PRODUCT WHERE id = :product_id";
    private String findByName = "SELECT * FROM Product as products WHERE name = :productName";
    private String findByContainedName = "SELECT * FROM Product WHERE name LIKE :productName";
    private String findByPrice = "SELECT * FROM Product WHERE price BETWEEN :minPrice AND :maxPrice";
    private String findByNameSortedAcc = "SELECT * FROM Product WHERE name LIKE :productName ORDER BY name";
    private String findByNameSortedDec = "SELECT * FROM Product WHERE name LIKE :productName ORDER BY name DESC";
    private String findByPriceSortedDec = "SELECT * FROM Product WHERE price BETWEEN :minPrice AND :maxPrice ORDER BY price DESC";

    public Product findById(long id) {
        try {
            Session session = createSessionFactory().openSession();
            return (Product) session.createNativeQuery(findById)
                    .setParameter("product_id", id).addEntity(Product.class).getSingleResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Can`t find Product by Id " + id);
        }
        sessionFactory.close();
        return null;
    }

    public List<Product> findByName(String name) {
        try {
            Session session = createSessionFactory().openSession();
            return (List<Product>) session.createNativeQuery(findByName)
                    .setParameter("productName", name).addEntity(Product.class).list();
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
            return (List<Product>)session.createNativeQuery(findByContainedName)
                    .setParameter("productName", name).addEntity(Product.class).list();
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
            return (List<Product>)session.createNativeQuery(findByPrice)
                    .setParameter("minPrice", price - delta).addEntity(Product.class)
                    .setParameter("maxPrice", price + delta).list();
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
            return (List<Product>)session.createNativeQuery(findByNameSortedAcc)
                    .setParameter("productName", name).addEntity(Product.class).list();
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
            return (List<Product>)session.createNativeQuery(findByNameSortedDec)
                    .setParameter("productName", name).addEntity(Product.class).list();
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
            return (List<Product>)session.createNativeQuery(findByPriceSortedDec)
                    .setParameter("minPrice", price - delta).setParameter("maxPrice", price + delta)
                    .addEntity(Product.class).list();
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
