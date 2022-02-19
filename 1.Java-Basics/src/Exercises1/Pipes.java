package Exercises;

import java.util.Scanner;

public class Pipes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = Integer.parseInt(scanner.nextLine());
        int p1 = Integer.parseInt(scanner.nextLine());
        int p2 = Integer.parseInt(scanner.nextLine());
        double H = Double.parseDouble(scanner.nextLine());
        double p1h = p1 * H;
        double p2h = p2 * H;
        double bothpipes = p1h + p2h;
        double bothpipespercent = (bothpipes / V) * 100;
        double pipepercentage1 = p1h / (bothpipes / 100);
        double pipepercentage2 = p2h / (bothpipes / 100);
        if (bothpipes > V) {
            double overflow = bothpipes - V;
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", H, overflow);
        } else {
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%% . Pipe 2: %.2f%% .", bothpipespercent, pipepercentage1, pipepercentage2);

        }
    }


}

