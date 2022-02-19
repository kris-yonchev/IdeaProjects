package FundamentalsExercise2;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pokePower = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustion = Integer.parseInt(scanner.nextLine());
        int currentPokepower = pokePower;
        int pokeCount = 0;
        while (currentPokepower >= distance) {
            currentPokepower -= distance;
            pokeCount++;
            if (currentPokepower == pokePower * 0.5 && exhaustion != 0) {
                currentPokepower /= exhaustion;
            }

        }
        System.out.printf("%d\n%d", currentPokepower, pokeCount);
    }
}
