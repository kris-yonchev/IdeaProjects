package ExamExercise;

import java.util.Scanner;

public class CatWalk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minutes = Integer.parseInt(scanner.nextLine());
        int walks = Integer.parseInt(scanner.nextLine());
        int calories = Integer.parseInt(scanner.nextLine());
        int minutes1 = minutes * walks;
        int sumcalories = minutes1 * 5;
        int condition = calories / 2;
        if (sumcalories >= condition) {
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.", sumcalories);
        } else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.", sumcalories);
        }
    }
}
