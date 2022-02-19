package Exam;

import java.util.Scanner;

public class FootballKit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double shirt = Double.parseDouble(scanner.nextLine());
        double goal = Double.parseDouble(scanner.nextLine());
        double shorts = shirt * 0.75;
        double socks = shorts * 0.20;
        double shoes = (shirt + shorts) * 2;
        double sum = (shirt + shorts + shoes + socks) * 0.85;
        if (sum >= goal) {
            System.out.printf("Yes, he will earn the world-cup replica ball!\nHis sum is %.2f lv.", sum);
        } else {
            System.out.printf("No, he will not earn the world-cup replica ball.\nHe needs %.2f lv. more.", Math.abs(goal - sum));
        }
    }
}
