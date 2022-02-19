package FundamentalsLecture4;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        double price = 0.0;

        switch (product) {
            case "coffee":
                price = 1.5;
                break;
            case "water":
                price = 1;
                break;
            case "coke":
                price = 1.4;
                break;
            case "snacks":
                price = 2;
                break;
        }
        timeToMath(quantity, price);

//coffee – 1.50
//water – 1.00
//coke – 1.40
//snacks – 2.00

    }

    private static void timeToMath(int quantity, double price) {
        System.out.printf("%.2f", quantity*price);
    }
}
