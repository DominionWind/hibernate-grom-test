package Lesson1;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository extends HibernateUtils{

    public Product save(Product product) {
        Session session = new HibernateUtils().createSession().openSession();
        try {
            session.getTransaction().begin();
            session.save(product);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.getStackTrace();
        } finally {
            session.close();
            shutDown();
        }
        return product;
    }

    public Product update(Product product) {
        Session session = new HibernateUtils().createSession().openSession();
        try {
            session.getTransaction().begin();
            session.update(product);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.getStackTrace();
        } finally {
            session.close();
            shutDown();
        }
        return product;
    }

    public void delete(long id) {
        Session session = new HibernateUtils().createSession().openSession();
        try {
            session.getTransaction().begin();
            Product product = new Product();
            product.setId(id);
            session.delete(product);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.getStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Product> read() {
        Session session = new HibernateUtils().createSession().openSession();
        ArrayList<Product> products = new ArrayList<>();
        try {
            session.getTransaction().begin();
            products.add((Product) session.createQuery("FROM PRODUCT").list());
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.getStackTrace();
        } finally {
            session.close();

        }
        return products;
    }
}
