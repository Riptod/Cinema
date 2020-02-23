package mate.academy.cinema.dto;

public class UserRequestDto {
    private String email;
    private String password;

    public UserRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserRequestDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
