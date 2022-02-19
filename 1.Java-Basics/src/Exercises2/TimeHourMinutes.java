package Exercises2;

import java.util.Scanner;

public class TimeHourMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        minutes = minutes + 15;
        if (minutes>59){
            hour++;
            minutes -=60;
        } if(hour > 23)
        {
            hour -= 24;
        } if (minutes<10){
            System.out.printf("%d:0%d", hour, minutes);
        } else {
        System.out.printf("%d:%d",hour ,minutes);
        }
    }
}
