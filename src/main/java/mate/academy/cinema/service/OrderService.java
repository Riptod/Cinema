package mate.academy.cinema.service;

import mate.academy.cinema.model.Order;
import mate.academy.cinema.model.User;

import java.util.List;

public interface OrderService {
    Order completeOrder(User user);

    List<Order> getOrderHistory(User user);
}
