package FundamentalsLecture4;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int cycle = Integer.parseInt(scanner.nextLine());
        repeatString(string, cycle);
    }

    private static void repeatString(String string, int cycle) {
        for (int i = 0; i < cycle; i++) {
            System.out.print(string);
        }
    }
}
