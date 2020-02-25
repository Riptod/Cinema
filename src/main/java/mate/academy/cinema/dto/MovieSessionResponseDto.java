package mate.academy.cinema.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MovieSessionResponseDto {
    @NotEmpty @NotNull
    private String title;
    @NotEmpty @NotNull
    private Long cinemaHallId;
    @NotEmpty @NotNull
    private String showTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
