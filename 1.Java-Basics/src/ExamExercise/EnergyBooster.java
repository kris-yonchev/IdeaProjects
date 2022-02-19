package ExamExercise;

import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        String size = scanner.nextLine();
        int sets = Integer.parseInt(scanner.nextLine());
        double price = 0.0;
        switch (type) {
            case "Watermelon":
                if (size.equals("big")) {
                    price = 5 * 28.70;
                } else if (size.equals("small")) {
                    price = 2 * 56;
                }
                break;
            case "Mango":
                if (size.equals("big")) {
                    price = 5 * 19.60;
                } else if (size.equals("small")) {
                    price = 2 * 36.66;
                }
                break;
            case "Pineapple":
                if (size.equals("big")) {
                    price = 5 * 24.80;
                } else if (size.equals("small")) {
                    price = 2 * 42.10;
                }
                break;
            case "Raspberry":
                if (size.equals("big")) {
                    price = 5 * 15.20;
                } else if (size.equals("small")) {
                    price = 2 * 20;
                }
                break;
        }
        double end = sets * price;
        if (end >= 400 && end <= 1000) {
            end *= 0.85;
        } else if (end > 1000) {
            end *= 0.5;
        }
        System.out.printf("%.2f lv.", end);

    }
}
