package interfaceAndAbstractionExercise.foodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Buyer> people = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] person = scanner.nextLine().split("\\s+");

            if (person.length > 3) {
                String personName = person[0];
                int personAge = Integer.parseInt(person[1]);
                String id = person[2];
                String birthDate = person[3];
                Citizen citizen = new Citizen(personName, personAge, id, birthDate);
                people.putIfAbsent(personName, citizen);
            } else {
                String rebelName = person[0];
                int rebelAge = Integer.parseInt(person[1]);
                String group = person[2];
                Rebel rebel = new Rebel(rebelName, rebelAge, group);
                people.putIfAbsent(rebelName, rebel);
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            if (people.containsKey(input)) {
                people.get(input).buyFood();
            }
            input = scanner.nextLine();
        }

        System.out.println(people.values().stream().mapToInt(Buyer::getFood).sum());

    }
}
