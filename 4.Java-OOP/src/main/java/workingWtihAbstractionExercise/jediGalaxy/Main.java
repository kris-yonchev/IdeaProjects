package workingWtihAbstractionExercise.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] galaxySize = getPositions(scanner.nextLine());
        int galaxyRows = galaxySize[0];
        int galaxyCols = galaxySize[1];

        Field field = new Field(galaxyRows, galaxyCols);
        Galaxy galaxy = new Galaxy(field);


        String command = scanner.nextLine();
        long starsCollected = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediPosition = getPositions(command);
            int[] evilPosition = getPositions(scanner.nextLine());

            int evilRow = evilPosition[0];
            int evilCol = evilPosition[1];
            galaxy.moveEvil(evilRow, evilCol);


            int jediRow = jediPosition[0];
            int jediCol = jediPosition[1];
            starsCollected = galaxy.moveJedi(jediRow, jediCol);

            command = scanner.nextLine();
        }

        System.out.println(starsCollected);


    }


    private static int[] getPositions(String scanner) {
        return Arrays.stream(scanner.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
