package FundamentalsExercise9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "[>]{2}(?<item>[A-z]+)[<]{2}(?<price>\\d+\\.?\\d*)\\!(?<quantity>\\d+)\\b";
        double sum = 0.0;
        List<String> items = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);


        while (!input.equals("Purchase")) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String product = matcher.group("item");
                int amount = Integer.parseInt(matcher.group("quantity"));
                double money = Double.parseDouble(matcher.group("price"));
                items.add(product);
                sum += amount * money;

            }
            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        for (String item : items) {
            System.out.println(item);
        }
        System.out.printf("Total money spend: %.2f", sum);
    }
}
