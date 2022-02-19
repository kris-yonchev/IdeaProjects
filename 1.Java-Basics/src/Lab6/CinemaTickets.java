package Lab6;

import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int kidsc = 0;
        int standardc = 0;
        int studentc = 0;
        int allc = 0;
        while (!input.equals("Finish")) {
            String name = input;
            int spots = Integer.parseInt(scanner.nextLine());
            int ticketcounter = 0;
            String type = scanner.nextLine();
            while (!type.equals("End")) {
                String typeticket = type;
                ticketcounter++;
                switch (typeticket) {
                    case "kid":
                        kidsc++;
                        break;
                    case "standard":
                        standardc++;
                        break;
                    case "student":
                        studentc++;
                        break;
                }
                if (ticketcounter == spots) {
                    break;
                }
                type = scanner.nextLine();

            }
            allc += ticketcounter;
            System.out.printf("%s - %.2f%% full.\n", name, ticketcounter * 1.0 / spots * 100);
            input = scanner.nextLine();
        }
        System.out.printf("Total tickets: %d\n" +
                "%.2f%% student tickets.\n" +
                "%.2f%% standard tickets.\n" +
                "%.2f%% kids tickets.", allc, studentc * 1.0 / allc * 100, standardc * 1.0 / allc * 100, kidsc * 1.0 / allc * 100);
    }
}
