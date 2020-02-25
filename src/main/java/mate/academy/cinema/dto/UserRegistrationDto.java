package mate.academy.cinema.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import mate.academy.cinema.lib.EmailConstraint;

public class UserRegistrationDto {
    @EmailConstraint @NotNull @NotEmpty
    private String email;
    @NotNull @NotEmpty @Min(6)
    private String password;
    @NotNull @NotEmpty @Min(6)
    private String repeatPassword;

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

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
