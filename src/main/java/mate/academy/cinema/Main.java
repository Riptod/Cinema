package mate.academy.cinema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import mate.academy.cinema.lib.Injector;
import mate.academy.cinema.model.CinemaHall;
import mate.academy.cinema.model.Movie;
import mate.academy.cinema.model.MovieSession;
import mate.academy.cinema.model.User;
import mate.academy.cinema.service.AuthenticationService;
import mate.academy.cinema.service.CinemaHallService;
import mate.academy.cinema.service.MovieService;
import mate.academy.cinema.service.MovieSessionServise;
import mate.academy.cinema.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.naming.AuthenticationException;

public class Main {
    private static Injector injector = Injector.getInstance("mate.academy.cinema");
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        movie.setDescription("Oh, shit, here we go again))");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        movieService.add(movie);

        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(100);
        cinemaHall.setDescription("Red hall");
        CinemaHallService cinemaHallService = (CinemaHallService) injector
                .getInstance(CinemaHallService.class);
        cinemaHallService.add(cinemaHall);
        cinemaHallService.getAll().forEach(System.out::println);

        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setShowTime(LocalDateTime.of(LocalDate.now(), LocalTime.of(19, 30)));
        MovieSessionServise movieSessionServise = (MovieSessionServise) injector
                .getInstance(MovieSessionServise.class);
        movieSessionServise.add(movieSession);
        movieSessionServise.findAvailableSessions(movie.getId(), LocalDate.now())
                .forEach(System.out::println);

        UserService userService = (UserService) injector.getInstance(UserService.class);
        AuthenticationService authenticationService = (AuthenticationService) injector
                .getInstance(AuthenticationService.class);
        authenticationService.register("bla bla", "admin");
        try {
            User user = authenticationService.login("bla bla", "admin");
            System.out.println(user);
        } catch (AuthenticationException e) {
            LOGGER.error("No find user", e);
        }
    }
}
