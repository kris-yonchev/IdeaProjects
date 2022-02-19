package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, LinkedHashMap<String, Double>> shops = new TreeMap<>();

        while (!input.equals("Revision")) {
            String[] info = input.split(", ");
            String shop = info[0];
            String product = info[1];
            double price = Double.parseDouble(info[2]);

            shops.putIfAbsent(shop, new LinkedHashMap<>());
            shops.get(shop).put(product, price);


            input = scanner.nextLine();
        }
        for (String shop : shops.keySet()) {
            System.out.printf("%s->\n", shop);
            for (var product : shops.get(shop).entrySet()) {
                System.out.printf("Product: %s Price: %.1f\n", product.getKey(), product.getValue());

            }
        }
    }
}
