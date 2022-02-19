package Exercise4;

import java.util.Scanner;

public class MonthlyPayments {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int months = Integer.parseInt(scanner.nextLine());
        double sumelec = 0.0;
        for (int i = 1; i <= 5; i++) {
            double electricity = Double.parseDouble(scanner.nextLine());
            sumelec += electricity;
        }
        double water = months * 20;
        double lan = months * 15;
        double others = ((water + lan + sumelec) * 0.2) + (water + lan + sumelec);
        double average = (water + lan + sumelec + others) / months;
        System.out.printf("Electricity: %.2f lv\n" +
                "Water: %.2f lv\n" +
                "Internet: %.2f lv\n" +
                "Other: %.2f lv\n" +
                "Average: %.2f lv\n", sumelec, water, lan, others, average);
    }
}
