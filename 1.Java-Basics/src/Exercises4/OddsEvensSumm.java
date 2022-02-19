package Exercise4;

import java.util.Scanner;

public class OddsEvensSumm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = Double.parseDouble(scanner.nextLine());
        double oddsum = 0.0;
        double evensum = 0.0;
        String no = "No";
        double maxo = -1000000000.0;
        double mino = 1000000000.0;
        double maxe = -1000000000.0;
        double mine = 1000000000.0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                double number = Double.parseDouble(scanner.nextLine());
                evensum += number;
                if (maxe < number) {
                    maxe = number;
                }
                if (mine > number) {
                    mine = number;
                }
            } else {
                double number = Double.parseDouble(scanner.nextLine());
                oddsum += number;
                if (maxo < number) {
                    maxo = number;
                }
                if (mino > number) {
                    mino = number;
                }
            }
        }
        if (oddsum != 0) {
            System.out.printf("OddSum=%.2f,\nOddMin=%.2f,\nOddMax=%.2f,\n", oddsum, mino, maxo);
        } else {
            System.out.printf("OddSum=%.2f,\nOddMin=%s,\nOddMax=%s,\n", oddsum, no, no);
        }
        if (evensum != 0) {
            System.out.printf("EvenSum=%.2f,\nEvenMin=%.2f,\nEvenMax=%.2f", evensum, mine, maxe);
        } else {
            System.out.printf("EvenSum=%.2f,\nEvenMin=%s,\nEvenMax=%s", evensum, no, no);
        }
    }
}
