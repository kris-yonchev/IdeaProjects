package FundamentalsLecture6;

import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger BigOne = new BigInteger(scanner.nextLine());
        BigInteger BigTwo = new BigInteger(scanner.nextLine());

        BigInteger sum = BigOne.add(BigTwo);
        System.out.println(sum);
    }
}
