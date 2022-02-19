package ExamExercise;

import java.util.Scanner;

public class Basketball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int winsTotal = 0;
        int lossTotal = 0;
        int allGames = 0;
        String input = scanner.nextLine();
        while (!input.equals("End of tournaments")) {
            String name = input;
            int games = Integer.parseInt(scanner.nextLine());
            int gameCounter = 0;
            for (int i = 1; i <= games; i++) {
                int score1 = Integer.parseInt(scanner.nextLine());
                int score2 = Integer.parseInt(scanner.nextLine());
                gameCounter++;
                allGames++;
                if (score1 > score2) {
                    winsTotal++;
                    System.out.printf("Game %d of tournament %s: win with %d points.\n", gameCounter, name, score1 - score2);
                } else if (score2>score1){
                    lossTotal++;
                    System.out.printf("Game %d of tournament %s: lost with %d points.\n", gameCounter, name, score2 - score1);
                }

            }
            input = scanner.nextLine();

        }
        System.out.printf("%.2f%% matches win\n%.2f%% matches lost", ((double) winsTotal / allGames) * 100, ((double) lossTotal / allGames) * 100);
    }
}
