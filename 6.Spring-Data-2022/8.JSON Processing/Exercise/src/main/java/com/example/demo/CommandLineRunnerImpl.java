package com.example.demo;

import com.example.demo.entities.dto.CategoriesInfoDto;
import com.example.demo.entities.dto.Q4.CountOfSellersDto;
import com.example.demo.entities.dto.ProductNameAndPriceDto;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;
import com.example.demo.services.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    Scanner scanner = new Scanner(System.in);
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final Gson gson;

    public CommandLineRunnerImpl(UserService userService, CategoryService categoryService, ProductService productService, Gson gson) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {
        seedDatabase();

//        queryOne();
//        queryTwo();
//        queryThree();
        queryFour();
    }

    private void queryFour() {
        CountOfSellersDto countOfSellersDto = this.userService.findAllUsersWithSales();

        String s = gson.toJson(countOfSellersDto);

        System.out.println(s);

    }

    private void queryThree() {
        List<CategoriesInfoDto> avgInfoForCategories = categoryService.findAvgInfoForCategories();

        String s = gson.toJson(avgInfoForCategories);
        System.out.println(s);
    }

    private void queryTwo() {
        userService.findAllWhoHaveSales()
                .stream()
                .map(gson::toJson)
                .forEach(System.out::println);
    }

    private void queryOne() {
        System.out.println("Enter lower bound: ");
        BigDecimal lower = new BigDecimal(scanner.nextLine());
        System.out.println("Enter upper bound: ");
        BigDecimal upper = new BigDecimal(scanner.nextLine());

        List<ProductNameAndPriceDto> allWthPriceInRange = productService.findPriceWithPriceInRange(lower, upper);
    }

    private void seedDatabase() throws IOException {
        userService.seedData();
        categoryService.seedData();
        productService.seedData();

    }
}
