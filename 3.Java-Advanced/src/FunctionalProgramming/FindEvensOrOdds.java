package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int beginN = nums[0];
        int endN = nums[1];
        String evenOrOdd = scanner.nextLine();

        printNumbers(beginN, endN, evenOrOdd.equals("even")
                ? n -> n % 2 == 0
                : n -> n % 2 != 0);

    }

    private static void printNumbers(int begin, int end, Predicate<Integer> predicate) {
        System.out.println(IntStream.rangeClosed(begin, end)
                .boxed().filter(predicate)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
