package FuntionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] name = scanner.nextLine().split("\\s+");
        Consumer<String> consumer = System.out::println;
        Arrays.stream(name).forEach(consumer);
    }
}
