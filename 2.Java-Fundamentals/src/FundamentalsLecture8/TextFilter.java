package FundamentalsLecture8;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            String censure = makeCensure(bannedWord);
            text=text.replace(bannedWord, censure);
        }
        System.out.println(text);
    }

    private static String makeCensure(String bannedWord) {
        String sb = "";
        for (int i = 0; i < bannedWord.length(); i++) {
            sb+="*";
        }
        return sb;
    }
}
