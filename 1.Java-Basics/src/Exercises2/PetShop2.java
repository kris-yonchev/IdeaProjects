package Exercises2;

import java.util.Scanner;

public class PetShop2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int foodleft = Integer.parseInt(scanner.nextLine());
        double dogfood = Double.parseDouble(scanner.nextLine());
        double catfood = Double.parseDouble(scanner.nextLine());
        double tfood = Double.parseDouble(scanner.nextLine())/1000;
        double foodndog = days * dogfood;
        double foodncat = days * catfood;
        double foodnt = days * tfood;
        double summfood = foodncat + foodndog + foodnt;
        if (summfood<=foodleft){
            double difference = Math.floor(foodleft - summfood);
            System.out.printf("%.0f kilos of food left.", difference);
        } else {
            double missing = Math.ceil(summfood - foodleft);
            System.out.printf("%.0f more kilos of food are needed.", missing);

        }
    }
}
