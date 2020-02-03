package mate.academy.cinema;

import mate.academy.cinema.exceptions.DataProcessingException;
import mate.academy.cinema.lib.Injector;
import mate.academy.cinema.model.Movie;
import mate.academy.cinema.service.MovieService;

public class main {
    private static Injector injector = Injector.getInstance("mate.academy.cinema");

    public static void main(String[] args) throws DataProcessingException {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        movieService.add(movie);

        movieService.getAll().forEach(System.out::println);
    }
}
