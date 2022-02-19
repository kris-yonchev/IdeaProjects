package Exercise6;

import java.util.Scanner;

public class WeddingSeats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lastSector = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int oddSeats = Integer.parseInt(scanner.nextLine());
        int seatCounter = 0;
        char sector = lastSector.charAt(0);
        for (int i = 65; i <= sector; i++) {
            if (i > 65) {
                rows++;
            }
            for (int j = 1; j <= rows; j++) {
                if (j % 2 != 0) {
                    for (int k = 97; k < 97 + oddSeats; k++) {
                        System.out.printf("%c%d%c\n", i, j, k);
                        seatCounter++;
                    }
                } else if (j % 2 == 0) {
                    for (int k = 97; k < 97 + (oddSeats + 2); k++) {
                        System.out.printf("%c%d%c\n", i, j, k);
                        seatCounter++;

                    }
                }

            }

        }
        System.out.println(seatCounter);
    }
}
