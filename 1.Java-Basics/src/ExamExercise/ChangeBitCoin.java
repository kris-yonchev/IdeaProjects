package ExamExercise;

import java.util.Scanner;

public class ChangeBitCoin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bitcoin = Integer.parseInt(scanner.nextLine());
        double ching = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine()) / 100;
        double bitsumm = bitcoin * 1168;
        double yuansum = (ching * 0.15) * 1.76;
        double euro = (bitsumm + yuansum) / 1.95;
        double exit = euro - (euro * commission);
        System.out.printf("%.2f", exit);
    }
}
