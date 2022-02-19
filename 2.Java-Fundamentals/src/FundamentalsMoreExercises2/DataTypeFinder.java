package FundamentalsMoreExercises2;

import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        while (!type.equals("END")) {
            Scanner input = new Scanner(type);
            if (input.hasNextInt()) {
                System.out.println(type + " is integer type");
            } else if (input.hasNextBoolean()) {
                System.out.println(type + " is boolean type");
            } else if (input.hasNextDouble()) {
                System.out.println(type + " is floating point type");
            } else if (type.length() == 1) {
                System.out.println(type + " is character type");
            } else if (input.hasNextLine()){
                System.out.println(type + " is string type");

            }
            type = scanner.nextLine();
        }
    }
}
