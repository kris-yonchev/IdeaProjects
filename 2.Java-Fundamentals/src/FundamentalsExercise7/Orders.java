package FundamentalsExercise7;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> orders = new LinkedHashMap<>();
        Map<String, Integer> oldValues = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("buy")) {
            String[] info = input.split("\\s+");
            String product = info[0];
            double price = Double.parseDouble(info[1]);
            int quantity = Integer.parseInt(info[2]);
            if (!orders.containsKey(product)) {
                orders.put(product, price * quantity);
                oldValues.put(product, quantity);
            } else {
                oldValues.put(product, oldValues.get(product) + quantity);
                orders.put(product, oldValues.get(product) * price);
            }

            input = scanner.nextLine();
        }
        orders.forEach((key, value) -> System.out.printf("%s -> %.2f\n", key, value));
    }
}
