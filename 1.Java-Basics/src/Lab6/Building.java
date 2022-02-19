package Lab6;

import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int floors = Integer.parseInt(scanner.nextLine());
        int rooms = Integer.parseInt(scanner.nextLine());
        for (int fl = floors; fl >= 1; fl--) {
            for (int r = 0; r < rooms; r++) {
                String letter = "";
                if (fl == floors) {
                    letter = "L";
                }
                else if (fl % 2 != 0) {
                    letter = "A";
                } else {
                    letter = "O";
                }
                System.out.printf("%s%d%d ", letter, fl, r);

            }
            System.out.println();
        }
    }
}
