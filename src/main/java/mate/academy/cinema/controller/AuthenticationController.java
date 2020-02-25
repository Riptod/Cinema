package mate.academy.cinema.controller;

import javax.naming.AuthenticationException;
import javax.validation.Valid;

import mate.academy.cinema.dto.UserLoginDto;
import mate.academy.cinema.dto.UserRegistrationDto;
import mate.academy.cinema.exceptions.DataProcessingException;
import mate.academy.cinema.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/register")
    public String registerUser(@RequestBody @Valid UserRegistrationDto requestDto)
            throws AuthenticationException {
        if (!requestDto.getPassword().equals(requestDto.getRepeatPassword())) {
            throw new DataProcessingException("Passwords do not match");
        }
        authenticationService.register(requestDto.getEmail(), requestDto.getPassword());
        return "Registration successfully";
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody @Valid UserLoginDto requestDto)
            throws AuthenticationException {
        authenticationService.login(requestDto.getEmail(), requestDto.getPassword());
        return "Login successfully";
    }
}
