package mate.academy.cinema.dao;

import mate.academy.cinema.exceptions.DataProcessingException;
import mate.academy.cinema.model.Movie;

import java.util.List;

public interface MovieDao {
    Movie add(Movie movie);

    List<Movie> getAll();
}
