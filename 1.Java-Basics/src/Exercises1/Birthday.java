package Exercises;

import java.util.Scanner;

public class Birthday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int loan = Integer.parseInt(scanner.nextLine());
        double cake = loan * 0.2;
        double drinks = cake - (cake * 0.45);
        double entert = loan / 3 ;
        double sum = loan + cake + drinks + entert ;
        System.out.println(sum);
    }
}
