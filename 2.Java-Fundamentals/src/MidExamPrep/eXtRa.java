package MidExamPrep;

import java.util.Scanner;

public class eXtRa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String output = "";
        for (int i = 1; i <= input.length(); i++) {
            char symbol = Character.toLowerCase(input.charAt(i-1));
            if (Character.isAlphabetic(input.charAt(i-1))) {
                if (i%2==0) {
                symbol = Character.toUpperCase(symbol);
                }
            }
            output+= symbol;
        }

        System.out.printf("%s\n", output);
        System.out.println(":)");
    }
}
