package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        UnaryOperator<Double> addVat = n -> n * 1.2;

        System.out.println("Prices with VAT:");

        Arrays.stream(input.split(", ")).map(Double::parseDouble).map(addVat).forEach(e -> {
            System.out.printf("%.2f\n", e);
        });

    }
}
