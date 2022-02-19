package FundamentalsMoreExercises2;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int leftCounter = 0;
        int rightCounter = 0;
        boolean isBalanced = true;
        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            if (input.length() == 1) {
                char symbol = input.charAt(0);
                if (symbol == 40) {
                    leftCounter++;
                    if (leftCounter - rightCounter >= 2) {
                        isBalanced = false;
                        break;
                    }
                } else if (symbol == 41) {
                    rightCounter++;
                    if (rightCounter>leftCounter) {
                        isBalanced =false;
                    }
                }
            }


        }
        if (!isBalanced || leftCounter != rightCounter) {
            System.out.println("UNBALANCED");
        } else {
            System.out.println("BALANCED");
        }
    }
}
