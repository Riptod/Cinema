package mate.academy.cinema.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import mate.academy.cinema.dto.MovieSessionRequestDto;
import mate.academy.cinema.dto.MovieSessionResponseDto;
import mate.academy.cinema.model.MovieSession;
import mate.academy.cinema.service.CinemaHallService;
import mate.academy.cinema.service.MovieService;
import mate.academy.cinema.service.MovieSessionServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moviesessions")
public class MovieSessionController {

    @Autowired
    private MovieSessionServise movieSessionServise;
    @Autowired
    private MovieService movieService;
    @Autowired
    private CinemaHallService cinemaHallService;

    @PostMapping
    public String addMovieSession(@RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(requestDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(requestDto.getCinemaHallId()));
        movieSession.setShowTime(LocalDateTime.parse(requestDto.getShowTime()));
        movieSessionServise.add(movieSession);
        return "Movie session added successfully";
    }

    @GetMapping(value = "/available")
    public List<MovieSessionResponseDto> findAvailableSessions(@RequestParam Long movieId,
                                                               @RequestParam LocalDate date) {
        return movieSessionServise.findAvailableSessions(movieId, date)
                .stream().map(this::movieSessionToDto).collect(Collectors.toList());
    }

    private MovieSessionResponseDto movieSessionToDto(MovieSession movieSession) {
        MovieSessionResponseDto responseDto = new MovieSessionResponseDto();
        responseDto.setTitle(movieSession.getMovie().getTitle());
        responseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        responseDto.setShowTime(movieSession.getShowTime().toString());
        return responseDto;
    }
}
