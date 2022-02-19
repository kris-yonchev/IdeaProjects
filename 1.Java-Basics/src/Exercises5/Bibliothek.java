package Exercises5;

import java.util.Scanner;

public class Bibliothek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String thebook = scanner.nextLine();
        String input = scanner.nextLine();
        int bookcounter = 0;
        boolean found = false;


        while (!input.equals("No More Books")) {
            if (input.equals(thebook)) {
                found = true;
                break;
            }
            bookcounter++;
            input = scanner.nextLine();
        }
        if (found) {
            System.out.printf("You checked %d books and found it.", bookcounter);
        } else {
            System.out.printf("The book you search is not here!\n" +
                    "You checked %d books.\n", bookcounter);
        }
    }
}
