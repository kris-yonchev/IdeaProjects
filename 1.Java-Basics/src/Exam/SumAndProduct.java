package Exam;

import java.util.Scanner;

public class SumAndProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        boolean notFound = true;
        for (int a = 1; a <= 9; a++) {
            if (!notFound) {
                break;
            }
            for (int b = 9; b >= a; b--) {
                if (!notFound) {
                    break;
                }
                for (int c = 0; c <= 9; c++) {
                    if (!notFound) {
                        break;
                    }
                    for (int d = 9; d >= c; d--) {
                        if ((a + b + c + d) == (a * b * c * d) && n % 10 == 5) {
                            notFound = false;
                            System.out.printf("%d%d%d%d", a, b, c, d);
                            break;
                        } else if ((a * b * c * d) / (a + b + c + d) == (int) 3 && n % 3 == 0) {
                            notFound = false;
                            System.out.printf("%d%d%d%d", d, c, b, a);
                            break;
                        }
                    }
                }
            }
        }
        if (notFound) {

            System.out.println("Nothing found");
        }
    }
}
