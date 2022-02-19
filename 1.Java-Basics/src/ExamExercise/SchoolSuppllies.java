package ExamExercise;

import java.util.Scanner;

public class SchoolSuppllies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pens = Integer.parseInt(scanner.nextLine());
        int markers = Integer.parseInt(scanner.nextLine());
        double detergent = Double.parseDouble(scanner.nextLine());
        double bonus = Double.parseDouble(scanner.nextLine()) / 100;
        double penprice = pens * 5.80;
        double markerprice = markers * 7.20;
        double detergentprice = detergent * 1.20;
        double sum = penprice + markerprice + detergentprice;
        double exit = sum - (sum * bonus);
        System.out.printf("%.3f", exit);
    }
}
