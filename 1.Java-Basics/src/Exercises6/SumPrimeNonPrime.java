package Exercise6;

import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int primesum = 0;
        int unprimesum = 0;
        while (!input.equals("stop")) {
            int number = Integer.parseInt(input);
            boolean isPrime = true;
            if (number == 1 || number == 0) {
                isPrime = false;
            }
            if (number < 0) {
                System.out.println("Number is negative.");
                input = scanner.nextLine();
                continue;
            }
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }

            }
            if (isPrime) {
                primesum += number;
            } else {
                unprimesum += number;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d\nSum of all non prime numbers is: %d", primesum, unprimesum);
    }
}
