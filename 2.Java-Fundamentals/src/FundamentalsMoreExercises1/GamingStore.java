package FundamentalsMoreExercises1;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        double spent = 0.0;
        double price = 0.0;
        while (!input.equals("Game Time")) {
            if (balance == 0) {
                break;
            }
            String game = input;
            switch (game) {
                case "OutFall 4":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                default:
                    System.out.println("Not Found");
                    break;
            }
            if (balance >= price && price > 0) {
                spent += price;
                balance -= price;
                System.out.printf("Bought %s\n", game);
            } else if (balance < price && price > 0) {
                System.out.println("Too Expensive");
            }
            input = scanner.nextLine();

        }
        if (balance > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spent, balance);
        } else {
            System.out.println("No more mo-ney!");
        }
    }
}
