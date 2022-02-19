package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double deposit = Double.parseDouble(scanner.nextLine());
        double dur = Double.parseDouble(scanner.nextLine());
        double yearly = Double.parseDouble(scanner.nextLine());
        double zinsen = ((deposit * yearly / 100) / 12);
        double sum = deposit + dur * zinsen;
        System.out.print(sum);

    }
}
