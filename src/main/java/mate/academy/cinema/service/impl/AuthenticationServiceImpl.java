package mate.academy.cinema.service.impl;

import javax.naming.AuthenticationException;
import mate.academy.cinema.dao.UserDao;
import mate.academy.cinema.model.User;
import mate.academy.cinema.service.AuthenticationService;
import mate.academy.cinema.service.RoleService;
import mate.academy.cinema.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private RoleService roleService;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        User user = userDao.findByEmail(email);
        if (user == null || !passwordEncoder.encode(password)
                .equals(user.getPassword())) {
            throw new AuthenticationException("Login, or password incorrect");
        }
        return user;
    }

    @Override
    public User register(String email, String password)
            throws AuthenticationException {
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.getRoles().add(roleService.getByName("USER"));
        User newUser = userDao.add(user);
        shoppingCartService.registerNewShoppingCart(newUser);
        return newUser;

    }
}
