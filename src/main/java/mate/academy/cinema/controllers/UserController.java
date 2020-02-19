package mate.academy.cinema.controllers;

import mate.academy.cinema.dto.UserRequestDto;
import mate.academy.cinema.dto.UserResponseDto;
import mate.academy.cinema.model.User;
import mate.academy.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/byemail")
    public UserResponseDto get(@RequestParam String email) {
        User user = userService.findByEmail(email);
        return new UserResponseDto(user.getId(), user.getEmail());
    }

    @PostMapping(value = "/")
    public void addUser(@RequestBody UserRequestDto requestDto) {
        User user = new User();
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());
        userService.add(user);
    }
}
