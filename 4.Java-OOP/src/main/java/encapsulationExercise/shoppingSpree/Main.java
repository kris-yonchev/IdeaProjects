package encapsulationExercise.shoppingSpree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> personMap = new LinkedHashMap<>();
        Map<String, Product> itemMap = new HashMap<>();

        String[] people = scanner.nextLine().split(";");
        for (String man : people) {
            String[] personData = man.split("=");
            String name = personData[0];
            double money = Double.parseDouble(personData[1]);

            try {
                Person person = new Person(name, money);
                personMap.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }


        String[] products = scanner.nextLine().split(";");
        for (String item : products) {
            String[] itemData = item.split("=");
            String itemName = itemData[0];
            double itemCost = Double.parseDouble(itemData[1]);

            try {
                Product product = new Product(itemName, itemCost);
                itemMap.put(itemName, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String[] command = input.split(" ");
            String buyerName = command[0];
            String productName = command[1];

            try {
                Person person = personMap.get(buyerName);
                Product product = itemMap.get(productName);
                person.buyProduct(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }


        for (Person person : personMap.values()) {
            System.out.print(person.getName() + " - ");
            if (person.getProducts().isEmpty()) {
                System.out.println("Nothing bought");
            } else {
                System.out.println(person.getProducts().stream().map(Product::getName).collect(Collectors.joining(", ")));
            }
        }
    }
}
