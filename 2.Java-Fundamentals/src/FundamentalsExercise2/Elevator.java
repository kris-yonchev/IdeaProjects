package FundamentalsExercise2;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());
        int sum = people / capacity;
        if (people % capacity != 0) {
            sum += 1;
        }
        System.out.printf("%d", sum);
    }
}
