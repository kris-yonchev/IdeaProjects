package FundamentalsExercise2;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingYield = Integer.parseInt(scanner.nextLine());
        int dayCounter = 0;
        int extractedSpice = 0;
        while (startingYield >= 100) {
            extractedSpice += startingYield - 26;
            startingYield -= 10;
            dayCounter++;
        }

        System.out.println(dayCounter);
        if (extractedSpice >= 26) {
            extractedSpice -= 26;
        }
        System.out.println(extractedSpice);
    }
}
