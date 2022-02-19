package FundamentalsExercise1;

import java.util.Scanner;

public class JediAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double saber = Double.parseDouble(scanner.nextLine());
        double robe = Double.parseDouble(scanner.nextLine());
        double belt = Double.parseDouble(scanner.nextLine());
        double rounded = Math.ceil(students * 0.1);
        int freebelts = (int) students / 6;
        double moneyNeeded = (saber * (students + rounded) + robe * students + belt * (students - freebelts));
        if (money >= moneyNeeded) {
            System.out.printf("The money is enough - it would cost %.2flv.", moneyNeeded);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", Math.abs(money - moneyNeeded));
        }
    }
}
