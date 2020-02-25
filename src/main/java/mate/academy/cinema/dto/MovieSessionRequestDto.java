package mate.academy.cinema.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MovieSessionRequestDto {
    @NotEmpty @NotNull
    private Long movieId;
    @NotEmpty @NotNull
    private Long cinemaHallId;
    @NotEmpty @NotNull
    private String showTime;

    public MovieSessionRequestDto(Long movieId, Long cinemaHallId, String showTime) {
        this.movieId = movieId;
        this.cinemaHallId = cinemaHallId;
        this.showTime = showTime;
    }

    public MovieSessionRequestDto() {
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
