package mate.academy.cinema.service;

import java.time.LocalDate;
import java.util.List;
import mate.academy.cinema.model.MovieSession;

public interface MovieSessionServise {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession add(MovieSession session);

    MovieSession get(Long id);
}
