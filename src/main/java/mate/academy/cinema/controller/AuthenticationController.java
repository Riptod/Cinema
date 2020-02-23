package mate.academy.cinema.controller;

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
    public String registerUser(@RequestBody UserRequestDto requestDto) {
        authenticationService.register(requestDto.getEmail(), requestDto.getPassword());
        return "Registration successfully";
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody UserRequestDto requestDto) throws AuthenticationException {
        authenticationService.login(requestDto.getEmail(), requestDto.getPassword());
        return "Login successfully";
    }
}
