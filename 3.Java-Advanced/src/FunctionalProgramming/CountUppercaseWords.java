package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("\\s+");

        Predicate<String> isUpperCase = word -> Character.isUpperCase(word.charAt(0));

        List<String> upperCase = Arrays.stream(text).filter(isUpperCase).collect(Collectors.toList());

        System.out.println(upperCase.size());
        System.out.println(String.join(System.lineSeparator(), upperCase));

    }
}
