package FuntionalProgrammingExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());


        String command = scanner.nextLine();

        while (!command.equals("Party!")) {
            Predicate<String> predicate = null;

            String criteria = command.split("\\s+")[2];

            if (command.contains("Length")) {

                predicate = e -> e.length() == Integer.parseInt(criteria);

            } else if (command.contains("StartsWith")) {

                predicate = e -> e.startsWith(criteria);

            } else {

                predicate = e -> e.endsWith(criteria);

            }
            if (command.contains("Remove")) {
                people.removeIf(predicate);

            } else {
                for (int i = 0; i < people.size(); i++) {
                    String guest = people.get(i);
                    if (predicate.test(guest)) {
                        people.add(i++, guest);
                    }
                }

            }


            command = scanner.nextLine();
        }

        if (people.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(people.stream().sorted().collect(Collectors.toCollection(ArrayList::new)).toString().replaceAll("([\\[\\]])", "")
                    + " are going to the party!");
        }
    }
}
