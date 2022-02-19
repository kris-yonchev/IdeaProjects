package FundamentalsExercise8;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\\\");
        String file = input[input.length - 1];
        String[] split = file.split("\\.");
        System.out.printf("File name: %s\nFile extension: %s", split[0], split[1]);
    }
}
