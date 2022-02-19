package Lab3;

import java.util.Scanner;

public class LocalShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        String city = scanner.nextLine();
        double amount = Double.parseDouble(scanner.nextLine());
        double sum = 0.0;
        if (city.equals("Sofia")) {
            switch (type) {
                case "coffee":
                    System.out.println(0.50 * amount);
                    break;
                case "water":
                    System.out.println(0.80 * amount);
                    break;
                case "beer":
                    System.out.println(1.20 * amount);
                    break;
                case "sweets":
                    System.out.println(1.45 * amount);
                    break;
                case "peanuts":
                    System.out.println(1.60 * amount);
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        } else if (city.equals("Plovdiv")) {
            switch (type) {
                case "coffee":
                    System.out.println(0.40 * amount);
                    break;
                case "water":
                    System.out.println(0.70 * amount);
                    break;
                case "beer":
                    System.out.println(1.15 * amount);
                    break;
                case "sweets":
                    System.out.println(1.30 * amount);
                    break;
                case "peanuts":
                    System.out.println(1.50 * amount);
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        } else if (city.equals("Varna")) {
            switch (type) {
                case "coffee":
                    System.out.println(0.45 * amount);
                    break;
                case "water":
                    System.out.println(0.70 * amount);
                    break;
                case "beer":
                    System.out.println(1.10 * amount);
                    break;
                case "sweets":
                    System.out.println(1.35 * amount);
                    break;
                case "peanuts":
                    System.out.println(1.55 * amount);
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }
    }
}
