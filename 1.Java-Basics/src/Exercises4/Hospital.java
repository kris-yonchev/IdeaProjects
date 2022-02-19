package Exercise4;

import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int period = Integer.parseInt(scanner.nextLine());
        int doctors = 7;
        int treated = 0;
        int untreated = 0;
        for (int i = 1; i <= period; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (i % 3 == 0) {
                if (untreated > treated) {
                    doctors++;
                }
            }
            if (number <= doctors) {
                treated += number;
            } else {
                treated += doctors;
                untreated += number - doctors;
            }
        }
        System.out.printf("Treated patients: %d.\nUntreated patients: %d.", treated, untreated);
    }
}
