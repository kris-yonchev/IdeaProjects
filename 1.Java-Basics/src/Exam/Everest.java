package Exam;

import java.util.Scanner;

public class Everest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int goal = 8848;
        int ananas = 5364;
        int dayscounter = 1;
        while (!input.equals("END")) {
            String text = input;
            int meters = Integer.parseInt(scanner.nextLine());
            if (text.equals("Yes")) {
                dayscounter++;
            }
            if (dayscounter > 5) {
                break;
            }
            ananas += meters;
            if (ananas >= goal) {
                System.out.printf("Goal reached for %d days!", dayscounter);
                break;
            }
            input = scanner.nextLine();
        }
        if (input.equals("END") || dayscounter > 5) {

            System.out.printf("Failed!\n%d", ananas);
        }

    }
}