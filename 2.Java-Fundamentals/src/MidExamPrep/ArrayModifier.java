package MidExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split(" ");
            if (command[0].equals("swap")) {

                int oldValue = array[Integer.parseInt(command[1])];
                array[Integer.parseInt(command[1])] = array[Integer.parseInt(command[2])];
                array[Integer.parseInt(command[2])] = oldValue;

            } else if (command[0].equals("multiply")) {

                array[Integer.parseInt(command[1])] = array[Integer.parseInt(command[1])] * array[Integer.parseInt(command[2])];

            } else if (command[0].equals("decrease")) {

                for (int i = 0; i < array.length; i++) {
                    array[i] = array[i] - 1;
                }
            }


            input = scanner.nextLine();
        }
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {

                System.out.print(array[i]);
            } else {

                System.out.print(array[i] + ", ");
            }
        }
    }
}
