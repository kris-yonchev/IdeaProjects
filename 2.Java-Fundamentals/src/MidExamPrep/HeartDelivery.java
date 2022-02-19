package MidExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] areaSize = Arrays.stream(scanner.nextLine().split("@")).mapToInt(e -> Integer.parseInt(e)).toArray();
        String input = scanner.nextLine();
        int houses = areaSize.length;
        int cupidPosition = 0;
        while (!input.equals("Love!")) {
            String[] commands = input.split(" ");
            int jumpLength = Integer.parseInt(commands[1]);
            cupidPosition += jumpLength;
            if (cupidPosition >= areaSize.length) {
                cupidPosition = 0;
            }
            if (areaSize[cupidPosition] != 0) {
                areaSize[cupidPosition] -= 2;
                if (areaSize[cupidPosition] == 0) {
                    System.out.printf("Place %d has Valentine's day.\n", cupidPosition);
                    houses--;
                }
            } else {
                System.out.printf("Place %d already had Valentine's day.\n", cupidPosition);
            }

            input = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.\n", cupidPosition);
        if (houses == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", houses);
        }
    }
}
