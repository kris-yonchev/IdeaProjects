package MidExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] targets = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        int shotTargets = 0;
        int currentTarget = 0;
        while (!input.equals("End")) {
            int targetToShoot = Integer.parseInt(input);
            if (targetToShoot > targets.length - 1) {
                input = scanner.nextLine();
                continue;
            }
            if (targets[targetToShoot] != -1) {
                currentTarget = targets[targetToShoot];
                targets[targetToShoot] = -1;
                shotTargets++;
                for (int i = 0; i < targets.length; i++) {
                    if (targets[i] != -1 && targets[i] > currentTarget) {
                        targets[i] -= currentTarget;
                    } else if (targets[i] != -1 && targets[i] <= currentTarget) {
                        targets[i] += currentTarget;
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", shotTargets);
        for (int i = 0; i < targets.length; i++) {
            System.out.print(targets[i] + " ");
        }
    }
}
