package mate.academy.cinema.dto;

import javax.validation.constraints.NotEmpty;

public class MovieDto {
    @NotEmpty
    private String title;
    private String description;

    public MovieDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public MovieDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
