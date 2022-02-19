package MidExamPrep;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        boolean exhausted = false;
        int winCount = 0;
        int streak = 0;
        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);
            if (distance > energy) {
                exhausted = true;
                break;
            }
            energy -= distance;
            winCount++;
            streak++;
            if (streak == 3) {
                energy += winCount;
                streak = 0;
            }
            input = scanner.nextLine();
        }
        if (!exhausted) {
            System.out.printf("Won battles: %d. Energy left: %d", winCount, energy);
        } else {
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", winCount, energy);
        }
    }
}
