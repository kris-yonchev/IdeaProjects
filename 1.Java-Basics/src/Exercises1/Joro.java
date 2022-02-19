package Exercises;

import java.util.Scanner;

public class Joro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = Integer.parseInt(scanner.nextLine());
        int pages = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int book = total / pages ;
        System.out.print(book / days);


    }
}
