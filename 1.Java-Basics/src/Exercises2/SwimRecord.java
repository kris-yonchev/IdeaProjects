package Exercises2;

import java.util.Scanner;

public class SwimRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double record = Double.parseDouble(scanner.nextLine());
        double meters = Double.parseDouble(scanner.nextLine());
        double mps = Double.parseDouble(scanner.nextLine());
        double secondsneeded = meters * mps;
        double slow1 = Math.floor(meters/15);
        double slow2 = slow1 * 12.5;
        double totaltime = secondsneeded + slow2;
        if (totaltime>=record){
            double surplus = Math.abs(record - totaltime);
            System.out.printf("No, he failed! He was %.2f seconds slower.", surplus);
            //No, he failed! He was 20786.00 seconds slower.
        } else {
            //Yes, he succeeded! The new world record is 17688.01 seconds.
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totaltime);
        }
    }
}
