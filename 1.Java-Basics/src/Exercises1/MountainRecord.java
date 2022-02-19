package Exercises;

import java.util.Scanner;

public class MountainRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double secondpermeter = Double.parseDouble(scanner.nextLine());

        double time = distance * secondpermeter;
        double wastedtime = Math.floor(distance / 50);
        double wastedtime2= wastedtime * 30;
        double totaltime = time + wastedtime2;
        if (totaltime>=record) {
            var surplus = totaltime - record;
            System.out.printf("No! He was %.2f seconds slower.", surplus);

        } else if (totaltime<record){
            System.out.printf("Yes! The new record is %.2f seconds.", totaltime);
        }

    }
}
