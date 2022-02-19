package Exercises3;

import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String year = scanner.nextLine();
        int hollidays = Integer.parseInt(scanner.nextLine());
        int weekends = Integer.parseInt(scanner.nextLine());
        double sofiagames = (48 - weekends) * (3.0/4);
        double sofiagames2 = hollidays * (2.0/3);
        double weekendgames = sofiagames + weekends + sofiagames2;
        if (year.equals("leap")){
            weekendgames = weekendgames + (weekendgames * 0.15);
        }
        System.out.printf("%.0f", Math.floor(weekendgames));
    }
}
