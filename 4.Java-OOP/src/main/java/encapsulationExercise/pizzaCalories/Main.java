package encapsulationExercise.pizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String[] pizzaInfo = scanner.nextLine().split("\\s+");
            String pizzaName = pizzaInfo[1];
            int numberOfToppings = Integer.parseInt(pizzaInfo[2]);
            Pizza pizza = new Pizza(pizzaName, numberOfToppings);

            String[] doughInfo = scanner.nextLine().split("\\s+");
            String doughType = doughInfo[1];
            String bakingType = doughInfo[2];
            double doughWeight = Double.parseDouble(doughInfo[3]);
            Dough dough = new Dough(doughType, bakingType, doughWeight);

            pizza.setDough(dough);

            String input = scanner.nextLine();

            while (!input.equals("END")) {
                String[] toppingInfo = input.split("\\s+");
                String toppingType = toppingInfo[1];
                double toppingWeight = Double.parseDouble(toppingInfo[2]);

                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);

                input = scanner.nextLine();
            }

            System.out.printf("%.2f", pizza.getOverallCalories());


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
