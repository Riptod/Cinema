package mate.academy.cinema.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import mate.academy.cinema.lib.EmailConstraint;
import mate.academy.cinema.lib.PasswordMatches;

@PasswordMatches
public class UserRegistrationDto {
    @EmailConstraint
    @NotNull
    private String email;
    @NotNull
    @Min(6)
    private String password;
    @NotNull
    @Min(6)
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
