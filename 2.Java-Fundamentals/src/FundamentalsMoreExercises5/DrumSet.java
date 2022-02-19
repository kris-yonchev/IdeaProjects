package FundamentalsMoreExercises5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> drumSet = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> ogDrumSet = new ArrayList<>(drumSet);
        String input = scanner.nextLine();
        while (!input.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(input);
            for (int i = 0; i < drumSet.size(); i++) {
                drumSet.set(i, drumSet.get(i) - hitPower);
                if (drumSet.get(i) <= 0) {
                    int drumPrice = ogDrumSet.get(i) * 3;
                    if (drumPrice <= savings) {
                        drumSet.set(i, ogDrumSet.get(i));
                        savings -= drumPrice;
                    } else {
                        drumSet.remove(i);
                        ogDrumSet.remove(i);
                        i-=1;
                    }
                }
            }

            input = scanner.nextLine();
        }
        for (Integer integer : drumSet) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
