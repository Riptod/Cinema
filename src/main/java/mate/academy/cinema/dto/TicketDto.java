package mate.academy.cinema.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TicketDto {
    @NotNull
    private Long ticketId;
    @NotNull
    @NotEmpty
    private String movieTitle;
    @NotNull
    @NotEmpty
    private String showTime;
    @NotNull
    private long cinemaHallId;

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }
}
