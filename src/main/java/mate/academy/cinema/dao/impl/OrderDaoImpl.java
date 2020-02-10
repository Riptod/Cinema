package mate.academy.cinema.dao.impl;

import mate.academy.cinema.dao.OrderDao;
import mate.academy.cinema.exceptions.DataProcessingException;
import mate.academy.cinema.lib.Dao;
import mate.academy.cinema.model.Order;
import mate.academy.cinema.model.User;
import mate.academy.cinema.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Dao
public class OrderDaoImpl implements OrderDao {
    @Override
    public Order add(Order order) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Long orderId = (Long) session.save(order);
            transaction.commit();
            order.setId(orderId);
            return order;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Cant add ticket", e);
        }
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Order> criteria = builder.createQuery(Order.class);
            Root<Order> root = criteria.from(Order.class);
            root.fetch("tickets", JoinType.LEFT);
            criteria.select(root).where(builder.equal(root.get("user"), user));
            return session.createQuery(criteria).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Couldn't get all orders ", e);
        }
    }
}
