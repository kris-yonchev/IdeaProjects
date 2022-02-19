package Lab5;

import java.util.Scanner;

public class WhileMaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stahp = scanner.nextLine();
        int max = Integer.MIN_VALUE;
        while (!stahp.equals("Stop")) {
            int number = Integer.parseInt(stahp);
            if (number > max) {
                max = number;
            }
            stahp = scanner.nextLine();
        }
        System.out.println(max);
    }
}
