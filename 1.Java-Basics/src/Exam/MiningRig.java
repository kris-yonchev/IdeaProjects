package Exam;

import java.util.Scanner;

public class MiningRig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gpu = Integer.parseInt(scanner.nextLine());
        int smth = Integer.parseInt(scanner.nextLine());
        double consumption = Double.parseDouble(scanner.nextLine());
        double profit = Double.parseDouble(scanner.nextLine());
        int gpuPrice = gpu * 13;
        int smthprice = smth * 13;
        int sum = gpuPrice + smthprice + 1000;
        double winPerDay = profit - consumption;
        winPerDay *= 13;
        double time = Math.ceil(sum/winPerDay);
        System.out.printf("%d\n%.0f", sum, time);

    }
}
