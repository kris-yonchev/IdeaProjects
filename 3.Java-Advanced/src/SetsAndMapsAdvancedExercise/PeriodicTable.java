package SetsAndMapsAdvancedExercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split("\\s+");
            set.addAll(Arrays.asList(elements));

        }
        for (String s : set) {
            System.out.print(s + " ");
        }
    }
}
