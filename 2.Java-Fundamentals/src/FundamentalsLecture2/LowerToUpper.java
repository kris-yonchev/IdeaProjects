package FundamentalsLecture2;

import java.util.Scanner;

public class LowerToUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char input = scanner.next().charAt(0);
        boolean isUpper = Character.isUpperCase(input);
        if (isUpper) {
            System.out.println("upper-case");
        } else {
            System.out.println("lower-case");
        }

    }
}
