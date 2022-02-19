package Exercises2;

import java.util.Scanner;

public class FirmHours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hoursNeeded = Integer.parseInt(scanner.nextLine());
        int availabledays = Integer.parseInt(scanner.nextLine());
        int overtime = Integer.parseInt(scanner.nextLine());
        double actualdays = availabledays - (availabledays * 0.1);
        actualdays *=8;
        double overtimehours = overtime * (2 * availabledays);
        double actualhours = Math.floor(overtimehours + actualdays);
        if (actualhours>=hoursNeeded){
            double surplus = actualhours - hoursNeeded;
            System.out.printf("Yes!%.0f hours left.", Math.floor(surplus));
        } else {
            double difference = hoursNeeded - actualhours;
            System.out.printf("Not enough time!%.0f hours needed.", Math.floor(difference));
        }
    }
}
