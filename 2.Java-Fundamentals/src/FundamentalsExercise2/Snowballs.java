package FundamentalsExercise2;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int snowballCount = Integer.parseInt(scanner.nextLine());
        double highestValue = Integer.MIN_VALUE;
        int currentBestSnow = 0;
        int currentBestTime = 0;
        int currentBestQuality = 0;

        for (int i = 1; i <= snowballCount; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            double snowballValue = Math.pow(1.0 * snowballSnow / snowballTime, snowballQuality);

            if (snowballValue > highestValue) {
                highestValue = snowballValue;
                currentBestSnow = snowballSnow;
                currentBestTime = snowballTime;
                currentBestQuality = snowballQuality;

            }
        }
        System.out.printf("%d : %d = %.0f (%d)", currentBestSnow,
                currentBestTime,
                highestValue,
                currentBestQuality);
    }
}
