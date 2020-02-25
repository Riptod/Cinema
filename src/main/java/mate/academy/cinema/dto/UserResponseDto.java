package mate.academy.cinema.dto;

public class UserResponseDto {
    private Long userId;
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
