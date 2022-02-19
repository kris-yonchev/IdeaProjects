package FundamentalsMoreExercises5;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> raceTrack = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int finishLine = raceTrack.size() / 2;
        double driverOneTime = 0;
        double driverTwoTime = 0;
        for (int i = 0; i < finishLine; i++) {
            if (raceTrack.get(i) == 0) {
                driverOneTime *= 0.8;
            }
            driverOneTime += raceTrack.get(i);

        }
        for (int i = raceTrack.size() - 1; i > finishLine; i--) {
            if (raceTrack.get(i) == 0) {
                driverTwoTime *= 0.8;
            }
            driverTwoTime += raceTrack.get(i);

        }
        if (driverOneTime < driverTwoTime) {
            System.out.printf("The winner is left with total time: %.1f", driverOneTime);
        } else {
            System.out.printf("The winner is right with total time: %.1f", driverTwoTime);
        }
    }
}
