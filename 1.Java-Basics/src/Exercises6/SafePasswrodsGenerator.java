package Exercise6;

import java.util.Scanner;

public class SafePasswrodsGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int maxPass = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        char symbol1 = 35;
        char symbol2 = 64;
        boolean stop = false;
            for (int i = 1; i <= n1; i++) {
                if (stop) {
                    break;
                }
                if (counter >= maxPass) {
                    break;
                }
                for (int j = 1; j <= n2; j++) {
                    System.out.printf("%c%c%d%d%c%c|", symbol1, symbol2, i, j, symbol2, symbol1);
                    if (i == n1 && j == n2) {
                        stop = true;
                        break;
                    }
                    counter++;
                    symbol1++;
                    if (counter >= maxPass) {
                        break;
                    }
                    if (symbol1 > 55) {
                        symbol1 = 35;
                    }
                    symbol2++;
                    if (symbol2 > 96) {
                        symbol2 = 64;
                    }

                }

            }


        }
    }
