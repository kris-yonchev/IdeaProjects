package ExamExercise;

import java.util.Scanner;

public class MountainRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double mpers = Double.parseDouble(scanner.nextLine());
        double time = distance * mpers;
        double penatly = Math.floor(distance / 50);
        double realtime = (penatly * 30) + time;
        if (realtime < record) {
            System.out.printf("Yes! The new record is %.2f seconds.", realtime);
        } else {
            System.out.printf("No! He was %.2f seconds slower.", Math.abs(record - realtime));
        }
    }
}
