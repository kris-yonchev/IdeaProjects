package FundamentalsExercise9;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^%(?<customerName>[A-Z][a-z]*)%[^|$%.]*<(?<item>\\w+)>[^|$%.]*\\|(?<quantity>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$$";
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);
        double total = 0.0;

        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("customerName");
                String itemName = matcher.group("item");
                int amount = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));
                total += amount * price;

                System.out.printf("%s: %s - %.2f\n", name, itemName, price * amount);
            }
            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f", total);

    }
}
