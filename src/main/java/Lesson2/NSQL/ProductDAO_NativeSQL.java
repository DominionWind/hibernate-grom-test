package Lesson2.NSQL;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO_NativeSQL {

    private SessionFactory sessionFactory;

    public Product findById(long id) {
        Product product = new Product();
        try {
            Session session = createSessionFactory().openSession();
            product = (Product) session.createNamedQuery("SELECT * FROM PRODUCT WHERE ID = :id")
                    .setParameter("id", id).getSingleResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Can`t find Product by Id " + id);
        }
        return product;
    }

    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        try {
            Session session = createSessionFactory().openSession();
            products.addAll(session.createNamedQuery("SELECT * FROM Product as products WHERE name = : name")
                    .setParameter("name", name).list());
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Can`t find Product by Name " + name);
        }
        return products;
    }

    public List<Product> findByContainedName(String name) {
        List<Product> products = new ArrayList<>();
        try {
            Session session = createSessionFactory().openSession();
            products.addAll(session.createNamedQuery("SELECT * FROM Product WHERE name LIKE : name")
                    .setParameter("name", name).list());
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Can`t find Product by Name " + name);
        }
        return products;
    }

    public List<Product> findByPrice(int price, int delta) {
        List<Product> products = new ArrayList<>();
        try {
            Session session = createSessionFactory().openSession();
            products.addAll(session.createNamedQuery("SELECT * FROM Product WHERE price BETWEEN :minPrice AND :maxPrice")
                    .setParameter("minPrice", price - delta).setParameter("maxPrice", price + delta).list());
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Can`t find Product by price " + price + " with delta " + delta);
        }
        return products;
    }

    public List<Product> findByNameSortedAcc(String name) {
        List<Product> products = new ArrayList<>();
        try {
            Session session = createSessionFactory().openSession();
            products.addAll(session.createNamedQuery("SELECT * FROM Product WHERE name LIKE : name ORDER BY name")
                    .setParameter("name", name).list());
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Can`t find Products by price " + name + " and sort them ACC");
        }
        return products;
    }

    public List<Product> findByNameSortedDec(String name) {
        List<Product> products = new ArrayList<>();
        try {
            Session session = createSessionFactory().openSession();
            products.addAll(session.createNamedQuery("SELECT * FROM Product WHERE name LIKE : name ORDER BY name DESC ")
                    .setParameter("name", name).list());
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Can`t find Products by price " + name + " and sort them DEC");
        }
        return products;
    }

    public List<Product> findByPriceSortedDec(int price, int delta) {
        List<Product> products = new ArrayList<>();
        try {
            Session session = createSessionFactory().openSession();
            products.addAll(session.createNamedQuery("SELECT * FROM Product WHERE price BETWEEN :minPrice AND :maxPrice ORDER BY price DESC ")
                    .setParameter("minPrice", price - delta).setParameter("maxPrice", price + delta).list());
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Can`t find Products by price " + price + " with delta " + delta + " and sort them DEC");
        }
        return products;
    }

    public SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
