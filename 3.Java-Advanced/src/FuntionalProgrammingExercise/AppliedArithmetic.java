package FuntionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();

        while (!command.equals("end")) {

            Function<int[], int[]> add = array -> Arrays.stream(array).map(num -> num += 1).toArray();
            Function<int[], int[]> minus = array -> Arrays.stream(array).map(num -> num -= 1).toArray();
            Function<int[], int[]> multi = array -> Arrays.stream(array).map(num -> num *= 2).toArray();
            Consumer<int[]> printer = array -> Arrays.stream(array).forEach(num -> System.out.print(num + " "));


            switch (command) {
                case "add":
                    nums = add.apply(nums);
                    break;
                case "subtract":
                    nums = minus.apply(nums);
                    break;
                case "multiply":
                    nums = multi.apply(nums);
                    break;
                case "print":
                    printer.accept(nums);
                    System.out.println();
                    break;
            }


            command = scanner.nextLine();
        }
    }
}
