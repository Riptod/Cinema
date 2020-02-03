package mate.academy.cinema.service.impl;


import mate.academy.cinema.dao.MovieDao;
import mate.academy.cinema.exceptions.DataProcessingException;
import mate.academy.cinema.lib.Inject;
import mate.academy.cinema.lib.Service;
import mate.academy.cinema.model.Movie;
import mate.academy.cinema.service.MovieService;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    private static MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public List<Movie> getAll() throws DataProcessingException {
        return movieDao.getAll();
    }
}
