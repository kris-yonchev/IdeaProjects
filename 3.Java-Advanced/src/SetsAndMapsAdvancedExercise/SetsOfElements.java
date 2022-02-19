package SetsAndMapsAdvancedExercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] num = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int setOne = num[0];
        int setTwo = num[1];
        LinkedHashSet<Integer> set1 = new LinkedHashSet<>();
        LinkedHashSet<Integer> set2 = new LinkedHashSet<>();
        for (int i = 0; i < setOne; i++) {
            set1.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < setTwo; i++) {
            set2.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int number : set1) {
            for (int numberTwo : set2) {
                if (number == numberTwo) {
                    System.out.print(number + " ");
                }
            }
        }
//        set1.retainAll(set2);
//        for (int n : set1) {
//            System.out.print(n+" ");
//        }
    }
}
