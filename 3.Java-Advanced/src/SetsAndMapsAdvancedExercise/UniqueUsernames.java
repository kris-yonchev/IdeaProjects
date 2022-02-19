package SetsAndMapsAdvancedExercise;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        HashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            set.add(input);
        }
        for (String name : set) {
            System.out.println(name);
        }
    }
}
