package FundamentalsExercise7;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> forceUsers = new TreeMap<>();
        while (!input.equals("Lumpawaroo")) {
            String[] command;
            String def = "";
            if (input.contains("|")) {
                command = input.split(" \\| ");
                def = "|";
            } else {
                command = input.split(" -> ");
                def = "->";
            }

            switch (def) {
                case "|":
                    String side = command[0];
                    String user = command[1];
                    boolean isThere = false;
                    for (Map.Entry<String, List<String>> current : forceUsers.entrySet()) {
                        if (current.getValue().contains(user)) {
                            isThere = true;
                            break;
                        }
                    }
                    if (!isThere) {
                        if (!forceUsers.containsKey(side)) {
                            forceUsers.put(side, new ArrayList<>());
                        }
                        forceUsers.get(side).add(user);
                    }

                    break;
                case "->":
                    String forceUser = command[0];
                    String otherSide = command[1];

                    for (Map.Entry<String, List<String>> entry : forceUsers.entrySet()) {
                        if (entry.getValue().contains(forceUser)) {
                            forceUsers.get(entry.getKey()).remove(forceUser);
                            break;
                        }
                    }

                    if (!forceUsers.containsKey(otherSide)) {
                        forceUsers.put(otherSide, new ArrayList<>());
                    }
                    forceUsers.get(otherSide).add(forceUser);
                    System.out.printf("%s joins the %s side!\n", forceUser, otherSide);

                    break;
            }


            input = scanner.nextLine();
        }
        forceUsers
                .entrySet()
                .stream().filter(users -> users.getValue().size() > 0)
                .sorted((n1, n2) -> Integer.compare(n2.getValue().size(), n1.getValue().size()))
                .forEach(e -> {
                    System.out.printf("Side: %s, Members: %d\n", e.getKey(), e.getValue().size());
                    e.getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(person -> System.out.printf("! %s\n", person));
                });
    }
}
