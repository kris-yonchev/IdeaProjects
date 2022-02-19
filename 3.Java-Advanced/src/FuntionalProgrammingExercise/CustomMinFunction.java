package FuntionalProgrammingExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Consumer<List<Integer>> consumer = n -> {
        int min = Collections.min(list);
            System.out.println(min);
        };
        consumer.accept(list);


//        Function<List<Integer>, Integer> function = n -> {
//            int min = Integer.MAX_VALUE;
//
//            for (int num : list) {
//                if (num < min) {
//                    min = num;
//                }
//            }
//            return min;
//        };
//        int n = function.apply(list);
//        System.out.println(n);

    }
}
