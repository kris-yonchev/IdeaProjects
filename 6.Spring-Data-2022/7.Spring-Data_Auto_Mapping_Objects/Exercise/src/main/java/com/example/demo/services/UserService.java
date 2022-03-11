package com.example.demo.services;

import com.example.demo.entities.User;

public interface UserService {

    String registerUser(String email, String password, String confirmPassword, String fullName);

    String loginUser(String email, String password);

    String logout();

    String purchaseGame(String gameTitle);

    User getLoggedUser();
}
