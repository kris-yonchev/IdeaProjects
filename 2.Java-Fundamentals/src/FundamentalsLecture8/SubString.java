package FundamentalsLecture8;

import java.util.Scanner;

public class SubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordToRemove = scanner.nextLine();
        String words = scanner.nextLine();
        while (words.contains(wordToRemove)) {
            words = words.replace(wordToRemove, "");

        }
        System.out.println(words);
    }
}
