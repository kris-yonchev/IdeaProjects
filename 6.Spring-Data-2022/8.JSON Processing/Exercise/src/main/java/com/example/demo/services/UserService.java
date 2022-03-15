package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.entities.dto.Q4.CountOfSellersDto;
import com.example.demo.entities.dto.UserNamesAndProductsDto;

import java.io.IOException;
import java.util.List;

public interface UserService {

    User findRandom();

    void seedData() throws IOException;

    List<UserNamesAndProductsDto> findAllWhoHaveSales();

    CountOfSellersDto findAllUsersWithSales();
}
