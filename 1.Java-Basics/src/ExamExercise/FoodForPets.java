package ExamExercise;

import java.util.Scanner;

public class FoodForPets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        double food = Double.parseDouble(scanner.nextLine());
        double sumcat = 0.0;
        double sumdog = 0.0;
        double bisciuts = 0.0;
        double currentbiscuits = 0.0;

        for (int i = 1; i <= days; i++) {
            double dog = Double.parseDouble(scanner.nextLine());
            double cat = Double.parseDouble(scanner.nextLine());
            sumdog += dog;
            sumcat += cat;
            if (i % 3 == 0) {
                currentbiscuits = (dog + cat) / 10;
                bisciuts += currentbiscuits;
            }
        }
        double eaten = (sumcat + sumdog);
        double avgeaten = (eaten / food) * 100;
        double cateaten = (sumcat / eaten) * 100;
        double dogeaten = (sumdog / eaten) * 100;
        System.out.printf("Total eaten biscuits: %dgr.\n" +
                "%.2f%% of the food has been eaten.\n" +
                "%.2f%% eaten from the dog.\n" +
                "%.2f%% eaten from the cat.\n", Math.round(bisciuts), avgeaten, dogeaten, cateaten);
    }
}
