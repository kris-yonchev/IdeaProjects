package Exercises2;

import java.util.Scanner;

public class TomCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int offdays = Integer.parseInt(scanner.nextLine());
        int workdays = 365-offdays;
        int offdaysplaytime = offdays * 127;
        int workdaysplaytime = workdays * 63;
        int playtime = offdaysplaytime + workdaysplaytime;
        int overunder= Math.abs(30000-playtime);
        int H = (overunder / 60);
        int M = (overunder % 60);
        if (playtime<30000){
            System.out.printf("Tom sleeps well\n%d hours and %d minutes less for play", H, M);
        } else {
            System.out.printf("Tom will run away\n%d hours and %d minutes more for play ", H, M);
        }

    }
}
