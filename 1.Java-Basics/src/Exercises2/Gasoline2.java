package Exercises2;

import java.util.Scanner;

public class Gasoline2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fuel = scanner.nextLine();
        double liters = Double.parseDouble(scanner.nextLine());
        String card = scanner.nextLine();
        double price = 0;
        double diesel = 2.33;
        double dieselDiscount = 0.12;
        double gasoline = 2.22;
        double gasolineDiscount = 0.18;
        double gas = 0.93;
        double gasDiscount = 0.08;
        if (card.equals("Yes")){
            diesel -=dieselDiscount;
            gasoline -=gasolineDiscount;
            gas -=gasDiscount;
        } switch (fuel){
            case "Gas":
                price = gas * liters;
                break;
            case "Gasoline":
                price = gasoline * liters;
                break;
            case "Diesel":
                price = diesel * liters;
                break;
            default:
                System.out.println("Invalid fuel!");
                break;
        } if (liters>25){
            price = price - (price * 0.10);
        } else if (liters>=20){
            price = price - (price * 0.08 );
        }
        System.out.printf("%.2f lv.",price);
    }
}
