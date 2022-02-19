package MidExamPrep;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double students = Double.parseDouble(scanner.nextLine());
        double lectures = Double.parseDouble(scanner.nextLine());
        double initialBonus = Double.parseDouble(scanner.nextLine());

        double maxBonus = 0;
        double maxAttended = 0;

        for (int i = 1; i <= students; i++) {
            double attendance = Double.parseDouble(scanner.nextLine());

            double bonus = (attendance / lectures) * (5 + initialBonus);

            if (bonus > maxBonus) {
                maxBonus = bonus;
                maxAttended = attendance;
            }

        }

        System.out.printf("Max Bonus: %.0f.\nThe student has attended %.0f lectures.", Math.ceil(maxBonus), maxAttended);
    }
}
