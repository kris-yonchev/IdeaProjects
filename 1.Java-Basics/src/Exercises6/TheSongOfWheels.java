package Exercise6;

import java.util.Scanner;

public class TheSongOfWheels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        String pass = "";
        int count = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        if (i < j && k > l) {
                            if (i * j + k * l == number) {
                                System.out.printf("%d%d%d%d ", i, j, k, l);
                                count++;
                                if (count == 4) {
                                    isFound = true;
                                    pass = "" + i + j + k + l;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (isFound) {
            System.out.printf("\nPassword: %s", pass);
        } else {
            System.out.println("\nNo!");
        }
    }
}
