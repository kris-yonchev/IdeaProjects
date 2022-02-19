package FundamentalsExercise3;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e-> Integer.parseInt(e)).toArray();
        boolean isEquals = false;
        if (numbers.length<1) {
            System.out.println("0");
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            int rightSum= 0;
            int leftSum= 0;


            for (int j = i-1; j >=0 ; j--) {
                leftSum+=numbers[j];
            }

            for (int j = i+1; j < numbers.length ; j++) {
                rightSum+=numbers[j];
            }
            if (leftSum==rightSum) {
                isEquals=true;
                System.out.print(i);
                break;
            }

        }
        if (!isEquals) {
            System.out.println("no");
        }
    }
}
