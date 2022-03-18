package com.example.demo.services;

import com.example.demo.entities.q4.ProductDto;
import com.example.demo.entities.q4.ProductInfoDto;
import com.example.demo.entities.q4.UserDto;
import com.example.demo.entities.q4.UserInfoDto;
import com.example.demo.entities.user.User;
import com.example.demo.entities.user.UserRootImportDto;
import com.example.demo.entities.user.UserWithProductDto;
import com.example.demo.entities.user.UserWithSoldProductsDto;
import com.example.demo.repositories.UserRepository;
import com.example.demo.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_FILE_PATH = "src/main/resources/users.xml";
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public void seedData() throws JAXBException, FileNotFoundException {
        if (userRepository.count() > 0) {
            return;
        }
        JAXBContext jaxbContext = JAXBContext.newInstance(UserRootImportDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        UserRootImportDto userRootImportDto = (UserRootImportDto) unmarshaller.unmarshal(new FileReader(USER_FILE_PATH));
        List<User> all = userRootImportDto
                .getUserImportDtos()
                .stream()
                .filter(validationUtil::isValid)
                .map(u -> modelMapper.map(u, User.class))
                .collect(Collectors.toList());

        userRepository.saveAll(all);
    }

    @Override
    public UserWithSoldProductsDto findUsersWithAtLeastOneSoldWithBuyer() {
        List<User> users = userRepository.findUserWithMoreThanOneSoldProductOrderBySoldProduct();
        UserWithSoldProductsDto userDto = new UserWithSoldProductsDto();
        userDto
                .setUserWithProductDtos(users.stream()
                        .filter(validationUtil::isValid)
                        .map(u -> modelMapper.map(u, UserWithProductDto.class))
                        .collect(Collectors.toList()));
        return userDto;
    }

    @Override
    public UserDto getUserWithAtLeastOneProductSold() {
        List<User> users = userRepository.getUserWithAtLeastOneProductSold();
        UserDto userDto = new UserDto();
        List<UserInfoDto> userInfoDtos = users.stream().map(u -> {
            UserInfoDto userInfoDto = modelMapper.map(u, UserInfoDto.class);

            List<ProductInfoDto> productInfoDtos = u
                    .getProductsSold()
                    .stream()
                    .map(p -> modelMapper.map(p, ProductInfoDto.class))
                    .collect(Collectors.toList());

            ProductDto productDto = new ProductDto();
            productDto.setCount(productInfoDtos.size());
            productDto.setSoldProducts(productInfoDtos);
            userInfoDto.setSoldProducts(productDto);
            return userInfoDto;
        }).collect(Collectors.toList());

        userDto.setUsers(userInfoDtos);
        userDto.setCount(userInfoDtos.size());
        return userDto;
    }


    @Override
    public User findRandom() {
        long rndId = ThreadLocalRandom.current().nextLong(1, userRepository.count() + 1);
        return userRepository.findById((int) rndId).orElse(null);
    }
}
