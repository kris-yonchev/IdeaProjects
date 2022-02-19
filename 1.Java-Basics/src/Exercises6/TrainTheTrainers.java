package Exercise6;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jury = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int gradecount = 0;
        double allgrades = 0;
        while (!input.equals("Finish")) {
            String presentation = input;
            double gradesum = 0.0;
            for (int i = 1; i <=jury ; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                gradecount++;
                gradesum += grade;
            }
            System.out.printf("%s - %.2f.\n", presentation, gradesum/jury);
            allgrades += gradesum;
            input= scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", allgrades/gradecount);

    }
}
