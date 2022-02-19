package FundamentalsExercise2;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double maxKeg = Integer.MIN_VALUE;
        String biggestKeg = "";
        for (int i = 1; i <= n; i++) {
            String type = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            double volumeKeg = Math.PI * Math.pow(radius, 2) * height;
            if (volumeKeg > maxKeg) {
                maxKeg = volumeKeg;
                biggestKeg = type;
            }

        }
        System.out.println(biggestKeg);
    }
}
