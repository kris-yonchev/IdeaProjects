package FundamentalsLecture4;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        String value1 = scanner.nextLine();
        String value2 = scanner.nextLine();
        switch (type) {
            case "int":
                int valueInt1 = Integer.parseInt(value1);
                int valueInt2 = Integer.parseInt(value2);
                System.out.println(getMax(valueInt1, valueInt2));
                break;
            case "char":
                char valueChar1 = value1.charAt(0);
                char valueChar2 = value2.charAt(0);
                System.out.println(getMax(valueChar1, valueChar2));
                break;
            case "string":
                String string1 = value1;
                String string2 = value2;
                System.out.println(getMax(string1, string2));
                break;

        }
    }

    private static int getMax(int value1, int value2) {
        if (value1 > value2) {
            return value1;
        }
        return value2;
    }

    private static char getMax(char value1, char value2) {
        if (value1 > value2) {
            return value1;
        }
        return value2;
    }

    private static String getMax(String value1, String value2) {
        if (value1.compareTo(value2)>0) {
            return value1;
        }
        return value2;
    }
}
