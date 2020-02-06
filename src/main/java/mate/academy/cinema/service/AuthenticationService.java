package mate.academy.cinema.service;

import mate.academy.cinema.model.User;

import javax.naming.AuthenticationException;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password);
}
