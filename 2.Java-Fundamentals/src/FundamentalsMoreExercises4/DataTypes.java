package FundamentalsMoreExercises4;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        String input = scanner.nextLine();
        getResult(type, input);
    }

    private static void getResult(String type, String input) {
        if (type.equals("int")) {
            System.out.printf("%d", Integer.parseInt(input) * 2);
        } else if (type.equals("real")) {
            System.out.printf("%.2f", Double.parseDouble(input) * 1.5);
        } else if (type.equals("string")){
            System.out.printf("$%s$", input);
        }
    }
}
