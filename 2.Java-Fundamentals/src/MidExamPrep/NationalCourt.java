package MidExamPrep;

import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        int questions = Integer.parseInt(scanner.nextLine());
        int answerPower = n1 + n2 + n3;
        int timeNeeded = 0;
        int iterrations = questions;
        for (int i = 1; i <= iterrations; i++) {
            if (i % 4 == 0) {
                timeNeeded++;
                continue;
            }
            questions -= answerPower;
            timeNeeded++;
            if (questions <= 0) {
                break;
            }

        }
        System.out.printf("Time needed: %dh.", timeNeeded);
    }
}
