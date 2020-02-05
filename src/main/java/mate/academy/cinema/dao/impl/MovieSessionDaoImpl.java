package mate.academy.cinema.dao.impl;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import mate.academy.cinema.dao.MovieSessionDao;
import mate.academy.cinema.exceptions.DataProcessingException;
import mate.academy.cinema.lib.Dao;
import mate.academy.cinema.model.MovieSession;
import mate.academy.cinema.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class MovieSessionDaoImpl implements MovieSessionDao {

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<MovieSession> criteriaQuery =
                    criteriaBuilder.createQuery(MovieSession.class);
            Root<MovieSession> root = criteriaQuery.from(MovieSession.class);
            Predicate predicateId = criteriaBuilder.equal(root.get("movie"), movieId);
            Predicate predicateDate = criteriaBuilder.between(root.get("showTime"),
                    date.atStartOfDay(), date.plusDays(1).atStartOfDay());
            criteriaQuery.select(root).where(criteriaBuilder.and(predicateId, predicateDate));
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Cannot find session from database", e);
        }
    }

    @Override
    public MovieSession add(MovieSession movieSession) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Long movieId = (Long) session.save(movieSession);
            transaction.commit();
            movieSession.setId(movieId);
            return movieSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Cant add movie session", e);
        }
    }
}
