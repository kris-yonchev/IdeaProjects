package com.example.demo;

import com.example.demo.entities.category.CategoryByCountDto;
import com.example.demo.entities.product.ProductsRootInRangeDto;
import com.example.demo.entities.q4.UserDto;
import com.example.demo.entities.user.UserWithSoldProductsDto;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    Scanner scanner = new Scanner(System.in);
    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public CommandLineRunnerImpl(UserService userService, ProductService productService, CategoryService categoryService) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
    }


    @Override
    public void run(String... args) throws Exception {
//        seedData();
//
//        queryOne();
//        queryTwo();
//        queryThree();
        queryFour();

    }

    private void queryFour() throws JAXBException {
        UserDto userDto = userService.getUserWithAtLeastOneProductSold();
        JAXBContext jaxbContext = JAXBContext.newInstance(UserDto.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(userDto, System.out);
    }

    private void queryThree() throws JAXBException {
        CategoryByCountDto categoryByCountDto = categoryService.findCategoryByProductCount();
        JAXBContext jaxbContext = JAXBContext.newInstance(CategoryByCountDto.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(categoryByCountDto, System.out);
    }


    private void queryTwo() throws JAXBException {
        UserWithSoldProductsDto userWithSoldProductsDto = userService.findUsersWithAtLeastOneSoldWithBuyer();
        JAXBContext jaxbContext = JAXBContext.newInstance(UserWithSoldProductsDto.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(userWithSoldProductsDto, System.out);
    }

    private void queryOne() throws JAXBException {
        System.out.println("Enter lower bound: ");
        BigDecimal lower = new BigDecimal(scanner.nextLine());
        System.out.println("Enter upper bound: ");
        BigDecimal upper = new BigDecimal(scanner.nextLine());
        ProductsRootInRangeDto productsRootInRangeDto = productService.findAllProductInRangeOrderByPrice(lower, upper);
        JAXBContext jaxbContext = JAXBContext.newInstance(ProductsRootInRangeDto.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(productsRootInRangeDto, System.out);
    }

    private void seedData() throws JAXBException, IOException {
        userService.seedData();
        categoryService.seedData();
        productService.seedData();


    }
}
