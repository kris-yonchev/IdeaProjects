package FundamentalsExercise5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> partyCast = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
            if (command[2].equals("going!")) {
                if (partyCast.contains(command[0])) {
                    System.out.printf("%s is already in the list!\n", command[0]);
                } else {
                    partyCast.add(command[0]);
                }
            } else {
                if (partyCast.contains(command[0])) {
                    partyCast.remove(command[0]);
                } else {
                    System.out.printf("%s is not in the list!\n", command[0]);
                }
            }
        }
        for (String s : partyCast) {
            System.out.println(s);
        }
    }
}
