package FundamentalsExercise1;

import java.util.Scanner;

public class Ages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        String type = "";
        if (age < 3) {
            type = "baby";
        } else if (age < 14) {
            type = "child";
        } else if (age < 20) {
            type = "teenager";
        } else if (age < 66) {
            type = "adult";
        } else {
            type = "elder";
        }
        System.out.println(type);
    }
}
