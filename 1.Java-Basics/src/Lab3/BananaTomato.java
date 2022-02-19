package Lab3;

import java.util.Scanner;

public class BananaTomato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        if (type.equals("banana") || type.equals("apple") || type.equals("kiwi") ||
                type.equals("cherry") || type.equals("lemon") || type.equals("grapes")) {
            System.out.println("fruit");
        } else if (type.equals("tomato") || type.equals("cucumber") || type.equals("pepper")
                || type.equals("carrot")) {
            System.out.println("vegetable");
        } else {
            System.out.println("unknown");
        }
    }
}
