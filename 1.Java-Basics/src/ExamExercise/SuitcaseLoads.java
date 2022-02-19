package ExamExercise;

import java.util.Scanner;

public class SuitcaseLoads {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double capacity = Double.parseDouble(scanner.nextLine());
        String end = scanner.nextLine();
        int i = 0;
        int suitcase = 0;
        boolean full = false;
        while (!end.equals("End")) {
            double volume = Double.parseDouble(end);
            i++;
            if (i % 3 == 0) {
                volume += volume * 0.1;
            }
            if (capacity < volume) {
                full = true;
                break;
            }
            suitcase++;
            capacity -= volume;
            end = scanner.nextLine();
        }
        if (full) {
            System.out.printf("No more space!\n" +
                    "Statistic: %d suitcases loaded.", suitcase);
        } else {
            System.out.printf("Congratulations! All suitcases are loaded!\n" +
                    "Statistic: %d suitcases loaded.", suitcase);
        }

    }
}
