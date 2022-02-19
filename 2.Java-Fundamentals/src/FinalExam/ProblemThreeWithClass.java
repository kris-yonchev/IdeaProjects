package FinalExam;

import java.util.Scanner;
import java.util.TreeMap;

public class ProblemThreeWithClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Stats> players = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("Results")) {
            String[] command = input.split(":");
            switch (command[0]) {
                case "Add":
                    String name = command[1];
                    int hp = Integer.parseInt(command[2]);
                    int energy = Integer.parseInt(command[3]);
                    if (!players.containsKey(name)) {
                        Stats stats = new Stats(hp, energy);
                        players.put(name, stats);
                    } else {
                        int newHp = players.get(name).getHp() + hp;
                        players.get(name).setEnergy(newHp);
                    }
                    break;
                case "Attack":
                    String attackerName = command[1];
                    String defenderName = command[2];
                    int dmg = Integer.parseInt(command[3]);
                    if (players.containsKey(attackerName) && players.containsKey(defenderName)) {
                        int defHp = players.get(defenderName).getHp() - dmg;
                        players.get(defenderName).setHp(defHp);
                        if (players.get(defenderName).getHp() <= 0) {
                            System.out.printf("%s was disqualified!\n", defenderName);
                            players.remove(defenderName);
                        }
                        int attackEnergy = players.get(attackerName).getEnergy() - 1;
                        players.get(attackerName).setEnergy(attackEnergy);
                        if (players.get(attackerName).getEnergy() <= 0) {
                            System.out.printf("%s was disqualified!\n", attackerName);
                            players.remove(attackerName);
                        }
                    }
                    break;
                case "Delete":
                    String userName = command[1];
                    if (userName.equals("All")) {
                        players.clear();
                    } else {
                        players.remove(userName);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("People count: %d\n", players.size());
        players.entrySet()
                .stream()
                .sorted((x1, x2) -> Integer.compare(x2.getValue().getHp(), x1.getValue().getHp()))
                .forEach(e -> System.out.printf("%s - %s\n", e.getKey(), e.getValue()));
    }

    static class Stats {
        private int hp;
        private int energy;

        public Stats(int hp, int energy) {
            this.hp = hp;
            this.energy = energy;
        }

        public int getHp() {
            return hp;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public void setEnergy(int energy) {
            this.energy = energy;
        }

        public int getEnergy() {
            return energy;
        }

        @Override
        public String toString() {
            return String.format("%d - %d\n", hp, energy);
        }
    }
}
