package Exercises5;

import java.util.Scanner;

public class StreamLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String word = "";
        boolean c = false;
        boolean o = false;
        boolean n = false;
        while (!text.equals("End")) {
            char a = text.charAt(0);
            if (Character.isAlphabetic(a)) {
                switch (a) {
                    case 'c':
                        if (c) {
                            word += text;
                        }
                        c = true;
                        break;
                    case 'o':
                        if (o) {
                            word += text;
                        }
                        o = true;
                        break;
                    case 'n':
                        if (n) {
                            word += text;
                        }
                        n = true;
                        break;
                    default:
                        word += text;
                        break;
                }
                if (c && o && n) {
                    System.out.print(word + " ");
                    n = false;
                    c = false;
                    o = false;
                    word = "";
                }
            }

            text = scanner.nextLine();
        }
    }
}
