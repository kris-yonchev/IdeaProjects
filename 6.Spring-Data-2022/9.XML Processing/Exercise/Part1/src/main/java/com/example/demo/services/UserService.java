package com.example.demo.services;

import com.example.demo.entities.q4.UserDto;
import com.example.demo.entities.user.User;
import com.example.demo.entities.user.UserWithSoldProductsDto;

import javax.xml.bind.JAXBException;
import java.io.IOException;


public interface UserService {

    User findRandom();

    void seedData() throws IOException, JAXBException;

    UserWithSoldProductsDto findUsersWithAtLeastOneSoldWithBuyer();

    UserDto getUserWithAtLeastOneProductSold();
}

