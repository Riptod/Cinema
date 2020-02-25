package mate.academy.cinema.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserResponseDto {
    @NotEmpty @NotNull
    private Long userId;
    @NotEmpty @NotNull @Min(6)
    private String email;

    public UserResponseDto(Long userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
