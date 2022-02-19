package ExamExercise;

import java.util.Scanner;

public class BarcodeGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int range1 = Integer.parseInt(scanner.nextLine());
        int range2 = Integer.parseInt(scanner.nextLine());
        for (int i = range1; i <= range2; i++) {
            String number = "" + i;
            int counter = 0;
            for (int j = 0; j < number.length(); j++) {
                char digit = number.charAt(j);
                if (digit % 2 == 0) {
                    break;
                } else {
                    counter++;
                }

            }
            if (counter == 4) {
                System.out.printf("%s ", number);
            }
        }
    }
}
