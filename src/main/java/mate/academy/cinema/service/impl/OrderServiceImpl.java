package mate.academy.cinema.service.impl;

import mate.academy.cinema.dao.OrderDao;
import mate.academy.cinema.dao.ShoppingCartDao;
import mate.academy.cinema.lib.Inject;
import mate.academy.cinema.lib.Service;
import mate.academy.cinema.model.Order;
import mate.academy.cinema.model.ShoppingCart;
import mate.academy.cinema.model.User;
import mate.academy.cinema.service.OrderService;
import mate.academy.cinema.service.ShoppingCartService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private ShoppingCartDao shoppingCartDao;
    @Inject
    private static OrderDao orderDao;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public Order completeOrder(User user) {
        ShoppingCart shoppingCart = shoppingCartDao.getByUser(user);
        Order order = new Order();
        order.setTickets(shoppingCart.getTickets());
        order.setUser(user);
        shoppingCartService.clear(shoppingCart);
        return orderDao.add(order);
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        return orderDao.getOrderHistory(user);
    }
}
