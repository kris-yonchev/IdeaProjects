package Lab5;

import java.util.Scanner;

public class CuboidsWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());
        int h = Integer.parseInt(scanner.nextLine());
        String d = scanner.nextLine();
        int volume = w * l * h;
        int amount = 0;
        while (!d.equals("Done")) {
            int box = Integer.parseInt(d);
            amount += box;
            if (volume < amount) {
                break;
            }
            d = scanner.nextLine();
        }
        if (volume < amount) {
            System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(volume - amount));
        } else {
            System.out.printf("%d Cubic meters left.", volume - amount);
        }
    }
}
