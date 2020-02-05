package mate.academy.cinema.service.impl;

import java.time.LocalDate;
import java.util.List;
import mate.academy.cinema.dao.MovieSessionDao;
import mate.academy.cinema.lib.Inject;
import mate.academy.cinema.lib.Service;
import mate.academy.cinema.model.MovieSession;

import mate.academy.cinema.service.MovieSessionServise;

@Service
public class MovieSessionServiceImpl implements MovieSessionServise {
    @Inject
    MovieSessionDao movieSessionDao;

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession add(MovieSession movieSession) {
        return movieSessionDao.add(movieSession);
    }
}
