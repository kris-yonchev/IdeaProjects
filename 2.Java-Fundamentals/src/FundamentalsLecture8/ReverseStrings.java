package FundamentalsLecture8;

import java.util.*;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String string = input;
            StringBuilder reversed = new StringBuilder();
            for (int i = string.length()-1; i >= 0; i--) {
                reversed.append(string.charAt(i));
            }
            System.out.printf("%s = %s\n", string, reversed);
            input = scanner.nextLine();
        }
    }
}
