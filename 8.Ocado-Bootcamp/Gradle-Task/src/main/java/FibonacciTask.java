import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FibonacciTask {

    public static void main(String[] args) {
        String testTest = "-n 25 -n 4 -v -h";
        String[] commandInfo = testTest.split(" ");
        int numberToCalculate;
        Map<Integer, Long> fibNumbersMap = new HashMap<>();
        int lastNumber = 0;


        for (int i = 0; i < commandInfo.length; i++) {
            switch (commandInfo[i]) {
                case "-n":
                case "--number":
                    if (commandInfo.length < 2) {
                        throw new IllegalArgumentException("Missing number argument!");
                    }
                    numberToCalculate = tryParseToNumber(commandInfo[i + 1]);
                    lastNumber = numberToCalculate;
                    i++;
                    System.out.println(getFibNumber(numberToCalculate, fibNumbersMap));
                    break;
                case "-v":
                case "--verbose":
                    if (fibNumbersMap.isEmpty()) {
                        System.out.println("Please, enter a number first! Use the command -n or --number followed by your number.");
                    } else {
                        for (int n : fibNumbersMap.keySet()) {
                            if (n != lastNumber) {
                                System.out.println(fibNumbersMap.get(n));
                            } else {
                                break;
                            }
                        }
                    }
                    break;
                case "-h":
                case "--help":
                    System.out.println("Enter '-n or --number + NUMBER you wish to calculate'.\n" +
                            "Enter '-v or --verbose' to print all numbers calculated before calculated result from your input number.\n" +
                            "Enter 'end' to end the program.");
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }


    }

    public static int tryParseToNumber(String string) {
        int n;
        try {
            n = Integer.parseInt(string);
            if (n < 0) {
                throw new IllegalArgumentException("Number must be positive!");
            }
            return n;
        } catch (NumberFormatException e) {
            System.out.println("Number argument is in fact not a number!");
        }
        return Integer.parseInt(string);
    }

    public static long getFibNumber(int number, Map<Integer, Long> cache) {
        if (number == 0 || number == 1) {
            return number;
        }
        if (cache.containsKey(number)) {
            return cache.get(number);
        }
        long x = getFibNumber(number - 1, cache) + getFibNumber(number - 2, cache);
        cache.put(number, x);
        return x;
    }
}
