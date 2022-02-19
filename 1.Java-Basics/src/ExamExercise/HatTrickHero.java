package ExamExercise;

import java.util.Scanner;

public class HatTrickHero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int goals = 0;
        String best = "";
        int maxg = Integer.MIN_VALUE;
        boolean trick = false;

        while (goals < 10) {
            String player = scanner.nextLine();
            if (player.equals("END")) {
                break;
            }
            int number = Integer.parseInt(scanner.nextLine());
            if (number > maxg) {
                goals += number;
                maxg = number;
                best = player;
                if (number >= 3) {
                    trick = true;
                }
            }
        }
        System.out.printf("%s is the best player!\n", best);
        if (trick) {
            System.out.printf("He has scored %d goals and made a hat-trick !!!", maxg);
        } else {
            System.out.printf("He has scored %d goals.", maxg);
        }
    }
}
