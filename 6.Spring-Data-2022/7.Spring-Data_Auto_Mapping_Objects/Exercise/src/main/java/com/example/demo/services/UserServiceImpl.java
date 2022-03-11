package com.example.demo.services;

import com.example.demo.entities.Game;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final GameService gameService;
    private User loggedUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, GameService gameService) {
        this.userRepository = userRepository;
        this.gameService = gameService;
    }

    @Override
    public String registerUser(String email, String password, String confirmPassword, String fullName) {

        if (!email.contains("@") || !email.contains(".")) {
            return "Incorrect email!";
        }

        Pattern passPattern = Pattern.compile("^[A-Z]+[a-z]+[\\d]+$");
        Matcher matcher = passPattern.matcher(password);
        if (!matcher.find() || password.length() < 6) {
            return "Incorrect username / password";
        }

        if (password.compareTo(confirmPassword) != 0) {
            return "Passwords do not match!";
        }

        User user = new User(email, password, fullName);
        userRepository.save(user);

        return String.format("%s was registered!", fullName.split("\\s+")[0]);
    }

    @Override
    public String loginUser(String email, String password) {
        User userByEmail = this.userRepository.findByEmail(email);
        if (userByEmail == null) {
            return "User with this email was not found!";
        }
        if (userByEmail.getPassword().compareTo(password) != 0) {
            return "Incorrect password!";
        }

        if (loggedUser != null) {
            return "Logout first!";
        } else {
            this.loggedUser = userByEmail;
        }

        return String.format("Successfully logged %s", userByEmail.getFullName().split("\\s+")[0]);
    }

    @Override
    public String logout() {
        if (this.loggedUser == null) {
            return "Cannot log out. No user was logged in.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Logged out user: ").append(this.loggedUser.getFullName()).append(System.lineSeparator());

        this.loggedUser = null;
        return sb.toString().trim();
    }

    @Override
    @Transactional
    public String purchaseGame(String gameTitle) {
        if (loggedUser == null) {
            return "No user logged!";
        }
        Game gameByTitle = gameService.findByTitle(gameTitle);

        if (gameByTitle == null) {
            return "No such game!";
        }

        loggedUser.purchase(gameByTitle);
        userRepository.save(loggedUser);
        return loggedUser.getFullName() + " purchased " + gameByTitle.getTitle();
    }

    @Override
    public User getLoggedUser() {
        return loggedUser;
    }
}
