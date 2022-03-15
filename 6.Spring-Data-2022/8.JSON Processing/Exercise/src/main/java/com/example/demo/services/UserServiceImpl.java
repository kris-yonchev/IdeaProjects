package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.entities.dto.*;
import com.example.demo.entities.dto.Q4.CountOfSellersDto;
import com.example.demo.entities.dto.Q4.ProductsDetailsDto;
import com.example.demo.entities.dto.Q4.SoldProductsDto;
import com.example.demo.entities.dto.Q4.UsersDto;
import com.example.demo.repositories.UserRepository;
import com.example.demo.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_FILE_PATH = "src/main/resources/users.json";
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper,
                           Gson gson, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }


    @Override
    public void seedData() throws IOException {
        if (userRepository.count() > 0) {
            return;
        }
        String s = Files.readString(Path.of(USER_FILE_PATH));
        UserInputDto[] userInputDtos = gson.fromJson(s, UserInputDto[].class);
        Arrays.stream(userInputDtos)
                .filter(validationUtil::isValid)
                .map(userInputDto -> modelMapper.map(userInputDto, User.class))
                .forEach(userRepository::save);
    }

    @Override
    public List<UserNamesAndProductsDto> findAllWhoHaveSales() {
        return userRepository.findAllByCountOfSalesMoreThanOne()
                .stream()
                .map(u -> modelMapper.map(u, UserNamesAndProductsDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CountOfSellersDto findAllUsersWithSales() {
        List<User> users = userRepository.findAllUsersWithMoreThanOneSoldProductsOrderBySoldProducts();
        CountOfSellersDto countOfSellersDto = new CountOfSellersDto();
        List<UsersDto> usersAndProductsDtos = users.stream()
                .map(u -> {
                    UsersDto userDto = modelMapper.map(u, UsersDto.class);

                    List<ProductsDetailsDto> productDtos = u.getProductsSold().stream()
                            .map(product -> modelMapper.map(product, ProductsDetailsDto.class))
                            .collect(Collectors.toList());

                    SoldProductsDto products = new SoldProductsDto();
                    products.setSoldProducts(productDtos);
                    products.setCount(productDtos.size());
                    userDto.setSoldProducts(products);

                    return userDto;
                }).collect(Collectors.toList());
        countOfSellersDto.setUsers(usersAndProductsDtos);
        countOfSellersDto.setUsersCount(users.size());
        return countOfSellersDto;
    }


    @Override
    public User findRandom() {
        long rndId = ThreadLocalRandom.current().nextLong(1, userRepository.count() + 1);
        return userRepository.findById((int) rndId).orElse(null);
    }
}
