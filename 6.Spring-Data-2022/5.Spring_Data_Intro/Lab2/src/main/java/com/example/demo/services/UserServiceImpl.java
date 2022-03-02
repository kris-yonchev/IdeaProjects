package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {

        if (this.userRepository.getUserByUserName(user.getUserName()) != null) {
            throw new IllegalArgumentException("User with that name already exists");
        }

        this.userRepository.save(user);


    }
}
