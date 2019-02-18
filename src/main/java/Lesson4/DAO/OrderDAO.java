package Lesson4.DAO;

import Lesson4.model.Order;

public class OrderDAO extends GeneralDAO<Order> {

    public OrderDAO() {
        setClass(Order.class);
    }



    public Order saveOrder(Order order) {
        return save(order);
    }

    public void deleteOrder(long id) {
        delete(id);
    }

    public Order updateOrder(Order order) {
        return update(order);
    }

    public Order findOrderById(long id) throws Exception {
        return findById(id);
    }
}
