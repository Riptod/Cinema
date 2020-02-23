package mate.academy.cinema.dto;

public class TicketDto {
    private Long ticketId;
    private String movieTitle;
    private String showTime;
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
