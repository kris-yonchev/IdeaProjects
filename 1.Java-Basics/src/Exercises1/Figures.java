package Exercises;

import java.util.Scanner;

public class Figures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String figure = scanner.nextLine();
        double area = 0.0;

        if (figure.equals("square")) {
            double a = Double.parseDouble(scanner.nextLine());
            area = Math.pow(a, 2);
        } else if (figure.equals("rectangle")) {
            double w = Double.parseDouble(scanner.nextLine());
            double h = Double.parseDouble(scanner.nextLine());
            area = w * h;
        } else if (figure.equals("circle")) {
            double r = Double.parseDouble(scanner.nextLine());
            area = Math.PI * (Math.pow(r, 2));
        } else if (figure.equals("triangle")) {
            double b = Double.parseDouble(scanner.nextLine());
            double h = Double.parseDouble(scanner.nextLine());
            area = b * h / 2;
        }
        System.out.println(area);


    }
}