package Exercises;

import java.util.Scanner;

public class Aqua {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());
        int volume = length * width * height;
        double liters = volume * 0.001;
        double percent1 = percent * 0.01;
        System.out.printf("%.2f", liters * (1-percent1));
    }
}
