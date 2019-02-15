package Lesson4.DAO;

import Lesson4.model.Order;

public class OrderDAO extends GeneralDAO {

    public OrderDAO() {
        setClass(Order.class);
    }

    public Order saveOrder(Order order) {
        return (Order) save(order);
    }

    public void deleteOrder(long id) {
        delete(id);
    }

    public Order updateOrder(Order order) {
        return (Order) update(order);
    }

    public Order findOrderById(long id) throws Exception {
        return (Order) findById(id);
    }
}
