package FundamentalsMoreExercises1;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        for (int i = name.length() - 1; i >= 0; i--) {
            char symbol = name.charAt(i);
            System.out.print(symbol);

        }
    }
}
