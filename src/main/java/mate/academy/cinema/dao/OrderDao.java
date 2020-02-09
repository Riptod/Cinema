package mate.academy.cinema.dao;

import mate.academy.cinema.model.Order;
import mate.academy.cinema.model.User;

import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrderHistory(User user);
}
