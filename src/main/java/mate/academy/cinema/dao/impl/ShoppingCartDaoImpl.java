package mate.academy.cinema.dao.impl;

import java.util.List;
import mate.academy.cinema.dao.ShoppingCartDao;
import mate.academy.cinema.exceptions.DataProcessingException;
import mate.academy.cinema.model.ShoppingCart;
import mate.academy.cinema.model.Ticket;
import mate.academy.cinema.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ShoppingCart add(ShoppingCart shoppingCart) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Long cartId = (Long) session.save(shoppingCart);
            transaction.commit();
            shoppingCart.setId(cartId);
            return shoppingCart;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Cant add shopping cart", e);
        }
    }

    @Override
    public ShoppingCart getByUser(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            List<Ticket> tickets = session.createQuery("select t from ShoppingCart as sc join "
                    + "sc.tickets as t where sc.user = :user", Ticket.class)
                    .setParameter("user", user).getResultList();
            Query<ShoppingCart> query = session
                    .createQuery("FROM ShoppingCart where user = :user", ShoppingCart.class)
                    .setParameter("user", user);
            ShoppingCart shoppingCart = query.uniqueResult();
            shoppingCart.setTickets(tickets);
            return shoppingCart;
        }
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(shoppingCart);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Cant add shopping cart", e);
        }
    }

    @Override
    public ShoppingCart get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(ShoppingCart.class, id);
        } catch (Exception e) {
            throw new DataProcessingException("Cannot get shopping cart by id: " + id, e);
        }
    }
}
