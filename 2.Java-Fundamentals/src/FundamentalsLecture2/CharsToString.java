package FundamentalsLecture2;

import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sum = "";
        for (int i = 1; i <= 3; i++) {
            String input = scanner.nextLine();
            sum += input;

        }
        System.out.println(sum);
    }
}
