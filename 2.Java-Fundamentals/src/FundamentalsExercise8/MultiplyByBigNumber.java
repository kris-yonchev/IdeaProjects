package FundamentalsExercise8;

import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyByBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger number = new BigInteger(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());
        System.out.println(number.multiply(BigInteger.valueOf(numberTwo)));
    }
}
