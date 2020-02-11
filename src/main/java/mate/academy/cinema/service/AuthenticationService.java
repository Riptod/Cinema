package mate.academy.cinema.service;

import javax.naming.AuthenticationException;
import mate.academy.cinema.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password);
}
