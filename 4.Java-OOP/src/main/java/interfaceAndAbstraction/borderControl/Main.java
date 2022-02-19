package interfaceAndAbstraction.borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> beingsToCheck = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] info = input.split("\\s+");
            Identifiable identifiable = info.length == 2 ?
                    new Robot(info[0], info[1]) :
                    new Citizen(info[0], Integer.parseInt(info[1]), info[2]);
            beingsToCheck.add(identifiable);

            input = scanner.nextLine();
        }

        String fakeId = scanner.nextLine();

        System.out.println(beingsToCheck
                .stream()
                .map(Identifiable::getId)
                .filter(i -> i.endsWith(fakeId))
                .collect(Collectors.joining(" ")));
    }
}
