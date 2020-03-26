package mate.academy.cinema.service.impl;

import java.time.LocalDate;
import java.util.List;
import mate.academy.cinema.dao.MovieSessionDao;
import mate.academy.cinema.model.MovieSession;
import mate.academy.cinema.service.MovieSessionServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieSessionServiceImpl implements MovieSessionServise {
    @Autowired
    private MovieSessionDao movieSessionDao;

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession add(MovieSession movieSession) {
        return movieSessionDao.add(movieSession);
    }

    @Override
    public MovieSession get(Long id) {
        return movieSessionDao.get(id);
    }
}
