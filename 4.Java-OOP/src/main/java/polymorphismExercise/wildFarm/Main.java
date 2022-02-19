package polymorphismExercise.wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] info = input.split("\\s+");
            Animal animal = createAnimal(info);

            String[] foodInfo = scanner.nextLine().split("\\s+");
            Food food = getFood(foodInfo);

            animal.makeSound();
            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            animals.add(animal);


            input = scanner.nextLine();
        }

        animals.forEach(System.out::println);

    }

    private static Food getFood(String[] foodInfo) {
        String type = foodInfo[0];
        int quantity = Integer.parseInt(foodInfo[1]);

        if (type.equals("Meat")) {
            return new Meat(quantity);
        } else {
            return new Vegetable(quantity);
        }
    }

    private static Animal createAnimal(String[] info) {
        String type = info[0];
        String name = info[1];
        double weight = Double.parseDouble(info[2]);
        String region = info[3];

        switch (type) {
            case "Mouse":
                return new Mouse(name, type, weight, region);
            case "Cat":
                return new Cat(name, type, weight, region, info[4]);
            case "Zebra":
                return new Zebra(name, type, weight, region);
            case "Tiger":
                return new Tiger(name, type, weight, region);
            default:
                throw new IllegalArgumentException("No such animal");
        }
    }
}
