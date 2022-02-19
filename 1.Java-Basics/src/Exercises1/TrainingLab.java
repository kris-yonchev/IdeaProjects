package Exercises;

import java.util.Scanner;

public class TrainingLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = Double.parseDouble(scanner.nextLine()) * 100;
        double width = (Double.parseDouble(scanner.nextLine()) - 1) * 100;
        int rows = (int) length / 120;
        int columbs = (int) width / 70;
        int seats = (int) rows * columbs - 3;
        System.out.println(seats);


    }
}
