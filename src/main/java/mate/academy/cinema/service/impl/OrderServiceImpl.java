package mate.academy.cinema.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import mate.academy.cinema.dao.OrderDao;
import mate.academy.cinema.model.Order;
import mate.academy.cinema.model.ShoppingCart;
import mate.academy.cinema.model.User;
import mate.academy.cinema.service.OrderService;
import mate.academy.cinema.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ShoppingCartService shoppingCartService;

    @Override
    public Order completeOrder(User user) {
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        Order order = new Order();
        order.setTickets(shoppingCart.getTickets());
        order.setUser(user);
        order.setOrderTime(LocalDateTime.now());
        return orderDao.add(order);
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        return orderDao.getOrderHistory(user);
    }
}
