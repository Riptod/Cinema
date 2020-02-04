package mate.academy.cinema.service;

import mate.academy.cinema.exceptions.DataProcessingException;
import mate.academy.cinema.model.Movie;

import java.util.List;

public interface MovieService {
    Movie add(Movie movie);

    List<Movie> getAll();
}
