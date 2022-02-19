package ExamExercise;

import java.util.Scanner;

public class PlaneTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int seniortickets = Integer.parseInt(scanner.nextLine());
        int juniortickets = Integer.parseInt(scanner.nextLine());
        double seniorprice = Double.parseDouble(scanner.nextLine());
        double tax = Double.parseDouble(scanner.nextLine());
        double juniorprice = seniorprice * 0.3;
        double sum = (seniorprice + tax) * seniortickets + (juniorprice + tax) * juniortickets;
        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", name, sum * 0.2);
    }
}
