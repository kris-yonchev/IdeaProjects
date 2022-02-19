package FinalExam;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProblemThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> peopleHp = new TreeMap<>();
        TreeMap<String, Integer> peopleEnergy = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Results")) {
            String[] command = input.split(":");
            switch (command[0]) {
                case "Add":
                    String personName = command[1];
                    int hp = Integer.parseInt(command[2]);
                    int energy = Integer.parseInt(command[3]);
                    if (!peopleEnergy.containsKey(personName)) {
                        peopleHp.put(personName, hp);
                        peopleEnergy.put(personName, energy);
                    } else {
                        peopleHp.put(personName, peopleHp.get(personName) + hp);
                    }
                    break;
                case "Attack":
                    String attackerName = command[1];
                    String defenderName = command[2];
                    int dmg = Integer.parseInt(command[3]);
                    if (peopleHp.containsKey(attackerName) && peopleHp.containsKey(defenderName)) {
                        peopleHp.put(defenderName, peopleHp.get(defenderName) - dmg);
                        if (peopleHp.get(defenderName) <= 0) {
                            System.out.printf("%s was disqualified!\n", defenderName);
                            peopleEnergy.remove(defenderName);
                            peopleHp.remove(defenderName);
                        }
                        peopleEnergy.put(attackerName, peopleEnergy.get(attackerName) - 1);
                        if (peopleEnergy.get(attackerName) <= 0) {
                            System.out.printf("%s was disqualified!\n", attackerName);
                            peopleEnergy.remove(attackerName);
                            peopleHp.remove(attackerName);
                        }
                    }
                    break;
                case "Delete":
                    String userName = command[1];
                    if (userName.equals("All")) {
                        peopleHp.clear();
                        peopleEnergy.clear();
                    } else if (peopleEnergy.containsKey(userName)) {
                        peopleHp.remove(userName);
                        peopleEnergy.remove(userName);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("People count: %d\n", peopleEnergy.size());
        peopleHp
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> {
                    int energy = peopleEnergy.get(e.getKey());
                    System.out.printf("%s - %d - %d\n", e.getKey(), e.getValue(), energy);
                });
    }
}
