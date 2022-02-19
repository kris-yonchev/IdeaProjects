package ExamExercise;

import java.util.Scanner;

public class Ballz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double sum = 0;
        int redcounter = 0;
        int orangecounter = 0;
        int yellowcounter = 0;
        int whitecounter = 0;
        int blackcounter = 0;
        int randomcounter = 0;
        for (int i = 1; i <= n; i++) {
            String ball = scanner.nextLine();
            switch (ball) {
                case "red":
                    redcounter++;
                    sum += 5;
                    break;
                case "orange":
                    orangecounter++;
                    sum += 10;
                    break;
                case "yellow":
                    yellowcounter++;
                    sum += 15;
                    break;
                case "white":
                    whitecounter++;
                    sum += 20;
                    break;
                case "black":
                    blackcounter++;
                    sum = Math.floor(sum / 2);
                    break;
                default:
                    randomcounter++;
                    break;
            }
        }
        System.out.printf("Total points: %.0f\nPoints from red balls: %d\nPoints from orange balls: %d\nPoints from yellow balls: %d\n"
                + "Points from white balls: %d\nOther colors picked: %d\nDivides from black balls: %d", sum, redcounter, orangecounter, yellowcounter, whitecounter, randomcounter, blackcounter);
    }
}
