package Lab5;

import java.util.Scanner;

public class WhileMinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stahp = scanner.nextLine();
        int min = Integer.MAX_VALUE;
        while (!stahp.equals("Stop")) {
            int number = Integer.parseInt(stahp);
            if (number < min) {
                min = number;
            }
            stahp = scanner.nextLine();
        }
        System.out.println(min);
    }
}
