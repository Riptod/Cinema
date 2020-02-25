package mate.academy.cinema.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CinemaHallDto {
    @NotNull
    private int capacity;
    @NotEmpty
    private String description;

    public CinemaHallDto(int capacity, String description) {
        this.capacity = capacity;
        this.description = description;
    }

    public CinemaHallDto() {
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
