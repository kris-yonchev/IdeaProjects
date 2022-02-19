package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numbers = scanner.nextLine();

        Function<String, Integer> countIntegers = s -> s.split(", ").length;
        Function<String, Integer> sumIntegers = s -> Arrays.stream(s.split(", ")).mapToInt(Integer::parseInt).sum();

        System.out.println("Count = " + countIntegers.apply(numbers));
        System.out.println("Sum = " + sumIntegers.apply(numbers));


    }
}
