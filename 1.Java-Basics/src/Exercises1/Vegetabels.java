package Exercises;

import java.util.Scanner;

public class Vegetabels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sumveggies = Double.parseDouble(scanner.nextLine());
        double sumfruits = Double.parseDouble(scanner.nextLine());
        int kgveggies = Integer.parseInt(scanner.nextLine());
        int kgfruits = Integer.parseInt(scanner.nextLine());
        double totalveggeis = sumveggies * kgveggies;
        double totalfruits = sumfruits * kgfruits;
        System.out.printf("%.2f", (totalfruits + totalveggeis) / 1.94);
    }
}
