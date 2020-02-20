package mate.academy.cinema.controller;

import java.util.List;
import java.util.stream.Collectors;

import mate.academy.cinema.dto.MovieDto;
import mate.academy.cinema.model.Movie;
import mate.academy.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public void addMovie(@RequestBody MovieDto requestDto) {
        Movie movie = new Movie();
        movie.setTitle(requestDto.getTitle());
        movie.setDescription(requestDto.getDescription());
        movieService.add(movie);
    }

    @GetMapping(value = "/")
    public List<MovieDto> getAll() {
        return movieService.getAll().stream().map(this::movieToDto)
                .collect(Collectors.toList());
    }

    private MovieDto movieToDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setTitle(movie.getTitle());
        movieDto.setDescription(movie.getDescription());
        return movieDto;
    }
}
