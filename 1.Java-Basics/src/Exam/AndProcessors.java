package Exam;

import java.util.Scanner;

public class AndProcessors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quota = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        double hours = workers * days * 8;
        double processorsMade = Math.floor(hours / 3);
        double diff = Math.abs(quota - processorsMade);
        if (processorsMade >= quota) {
            System.out.printf("Profit: -> %.2f BGN", diff * 110.10);
        } else {
            System.out.printf("Losses: -> %.2f BGN", diff * 110.10);
        }
    }
}
