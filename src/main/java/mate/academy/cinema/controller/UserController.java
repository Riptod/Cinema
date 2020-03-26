package mate.academy.cinema.controller;

import javax.validation.Valid;
import mate.academy.cinema.dto.UserRegistrationDto;
import mate.academy.cinema.dto.UserResponseDto;
import mate.academy.cinema.model.User;
import mate.academy.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/byemail")
    public UserResponseDto get(@RequestParam Authentication authentication) {
        User user = userService.findByEmail(authentication.getName());
        return new UserResponseDto(user.getId(), user.getEmail());
    }

    @PostMapping
    public String addUser(@RequestBody @Valid UserRegistrationDto requestDto) {
        User user = new User();
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());
        userService.add(user);
        return "user added successfully";
    }
}
