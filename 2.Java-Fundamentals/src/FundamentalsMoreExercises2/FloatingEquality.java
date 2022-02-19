package FundamentalsMoreExercises2;

import java.math.BigDecimal;
import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n1 = Double.parseDouble(scanner.nextLine());
        double n2 = Double.parseDouble(scanner.nextLine());
        double precision = 0.000001;
        double diff =Math.abs(n1 - n2) ;
        if (diff >= precision) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }



    }
}
