package Exercise4;

import java.util.Scanner;

public class Gehalt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tabs = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= tabs; i++) {
            String website = scanner.nextLine();
            switch (website) {
                case "Facebook" -> salary -= 150;
                case "Instagram" -> salary -= 100;
                case "Reddit" -> salary -= 50;
            }
            if (salary <= 0) {
                break;
            }

        }
        if (salary <= 0) {
            System.out.println("You have lost your salary.");
        } else {
            System.out.printf("%d", salary);
        }

    }
}
