package com.example.advquerying;

import com.example.advquerying.entities.Size;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


@Component
public class Runner implements CommandLineRunner {


    private final Scanner scanner = new Scanner(System.in);
    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    public Runner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {


        System.out.println("Enter task number to execute[1-11]: ");
        int taskNumber = Integer.parseInt(scanner.nextLine());
        switch (taskNumber) {
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            case 3:
                task3();
                break;
            case 4:
                task4();
                break;
            case 5:
                task5();
                break;
            case 6:
                task6();
                break;
            case 7:
                task7();
                break;
            case 8:
                task8();
                break;
            case 9:
                task9();
                break;
            case 10:
                task10();
                break;
            case 11:
                task11();
                break;
            default:
                System.out.println("invalid task number!");
                break;
        }

    }

    private void task11() {
        System.out.println("Enter names of ingredients: ");
        Set<String> ingredientsToUpdate = Set.of(scanner.nextLine().split(" "));
        System.out.println(ingredientService.updateIngredientPriceBy10PercentWithName(ingredientsToUpdate));
    }

    private void task10() {
        System.out.println(ingredientService.updateIngredientPriceBy10Percent());
    }

    private void task9() {
        System.out.println("Enter name to delete from ingredients: ");
        String name = scanner.nextLine();
        int i = ingredientService.deleteIngredientsByName(name);
        System.out.println(i);
    }

    private void task8() {
        System.out.println("Enter count: ");
        int number = Integer.parseInt(scanner.nextLine());
        shampooService.findAllByIngredientsLessThan(number)
                .forEach(s -> System.out.println(s.getBrand()));
    }

    private void task7() {
        System.out.println("Enter ingredients: ");
        Set<String> ingredients = Set.of(scanner.nextLine().split(" "));

        shampooService.findAllByIngredients(ingredients)
                .forEach(s -> System.out.println(s.getBrand()));
    }

    private void task6() {
        System.out.println("Enter price to sort by: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());

        System.out.println(shampooService.countAllByPriceLessThan(price));
    }

    private void task5() {
        System.out.println("Enter ingredients: ");
        List<String> names = Arrays.asList(scanner.nextLine().split(" "));

        ingredientService.findAllByNameInOrderByPrice(names)
                .forEach(i -> System.out.println(i.getName()));
    }

    private void task4() {
        System.out.println("Enter letter to sort by.");
        String letter = scanner.nextLine();
        ingredientService.findByNameStartingWith(letter)
                .forEach(i -> System.out.println(i.getName()));
    }

    private void task3() {
        System.out.println("Enter price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        shampooService.findByPriceGreaterThanOrderByPriceDesc(price)
                .forEach(System.out::println);
    }

    private void task2() {
        System.out.println("Enter size: ");
        Size size = Size.valueOf(scanner.nextLine());
        System.out.println("Enter label id: ");
        Long id = Long.valueOf(scanner.nextLine());
        this.shampooService.findBySizeOrLabelIdOrderByPriceAsc(size, id)
                .forEach(System.out::println);
    }

    private void task1() {
        System.out.println("Enter size to sort by.");
        Size size = Size.valueOf(scanner.nextLine());
        this.shampooService.findBySize(size)
                .forEach(System.out::println);
    }

}
