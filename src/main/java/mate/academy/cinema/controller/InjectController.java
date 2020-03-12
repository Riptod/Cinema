package mate.academy.cinema.controller;

import javax.annotation.PostConstruct;

import mate.academy.cinema.model.Role;
import mate.academy.cinema.model.User;
import mate.academy.cinema.service.RoleService;
import mate.academy.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InjectController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleService roleService;

    @PostConstruct
    private void postConstruct() {
        Role userRole = new Role();
        userRole.setRoleName("USER");
        Role adminRole = new Role();
        adminRole.setRoleName("ADMIN");
        roleService.add(userRole);
        roleService.add(adminRole);

        User user = new User();
        user.setEmail("user@user.com");
        user.setPassword(passwordEncoder.encode("123"));
        user.getRoles().add(adminRole);
        userService.add(user);
    }
}
