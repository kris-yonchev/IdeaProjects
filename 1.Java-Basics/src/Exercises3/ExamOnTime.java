package Exercises3;

import java.util.Scanner;

public class ExamOnTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int examhour = Integer.parseInt(scanner.nextLine());
        int exammin = Integer.parseInt(scanner.nextLine());
        int arrivalhour = Integer.parseInt(scanner.nextLine());
        int arrivalmin = Integer.parseInt(scanner.nextLine());
        int examtime = examhour * 60 + exammin;
        int arrivaltime = arrivalhour * 60 + arrivalmin;
        int difference = examtime - arrivaltime;
        if (difference > 30) {
            System.out.println("Early");
            if (difference > 59) {
                int hours = difference / 60;
                int mins = difference % 60;
                System.out.printf("%d:%02d hours before the start", hours, mins);
            } else {
                System.out.printf("%d minutes before the start", difference);
            }
        } else if (difference < 0) {
            System.out.println("Late");
            int late = Math.abs(difference);
            if (late > 59) {
                int hours = late / 60;
                int mins = late % 60;
                System.out.printf("%d:%02d hours after the start", hours, mins);
            } else {
                System.out.printf("%d minutes after the start", late);
            }
        } else {
            System.out.println("On time");
            if (difference > 0) {
                System.out.printf("%d minutes before the start", difference);
            }
        }
    }
}

