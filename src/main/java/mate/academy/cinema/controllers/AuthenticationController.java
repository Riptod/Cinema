package mate.academy.cinema.controllers;

import javax.naming.AuthenticationException;

import mate.academy.cinema.dto.UserRequestDto;
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
    public void registerUser(@RequestBody UserRequestDto requestDto) {
        authenticationService.register(requestDto.getEmail(), requestDto.getPassword());
    }

    @PostMapping(value = "/login")
    public void login(@RequestBody UserRequestDto requestDto) throws AuthenticationException {
        authenticationService.login(requestDto.getEmail(), requestDto.getPassword());
    }
}
