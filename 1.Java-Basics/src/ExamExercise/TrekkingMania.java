package ExamExercise;

import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groups = Integer.parseInt(scanner.nextLine());
        int Musala = 0;
        int Monblan = 0;
        int Kili = 0;
        int K2 = 0;
        int Everest = 0;
        int all = 0;
        for (int i = 1; i <= groups; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            all += number;
            if (number < 6) {
                Musala += number;
            } else if (number <= 12) {
                Monblan += number;
            } else if (number <= 25) {
                Kili += number;
            } else if (number <= 40) {
                K2 += number;
            } else {
                Everest += number;
            }
        }
        double avgMus = (double) Musala / all * 100;
        double avgKili = (double) Kili / all * 100;
        double avgK2 = (double) K2 / all * 100;
        double avgEver = (double) Everest / all * 100;
        double avgMon = (double) Monblan / all * 100;
        System.out.printf("%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%", avgMus, avgMon, avgKili, avgK2, avgEver);
    }
}
