package encapsulationExercise.footballTeamGenerator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Team> teamMap = new HashMap<>();

        while (!input.equals("END")) {
            String[] command = input.split(";");
            String teamName = command[1];
            switch (command[0]) {
                case "Team":
                    try {
                        Team team = new Team(teamName);
                        teamMap.putIfAbsent(teamName, team);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Add":
                    String playerName = command[2];
                    int playerEndurance = Integer.parseInt(command[3]);
                    int playerSprint = Integer.parseInt(command[4]);
                    int playerDribble = Integer.parseInt(command[5]);
                    int playerPassing = Integer.parseInt(command[6]);
                    int playerShooting = Integer.parseInt(command[7]);
                    try {
                        if (!teamMap.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.\n", teamName);
                            break;
                        }
                        Player player = new Player(playerName, playerEndurance, playerSprint, playerDribble, playerPassing, playerShooting);
                        teamMap.get(teamName).addPlayer(player);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Remove":
                    String playerToRemove = command[2];
                    try {
                        if (!teamMap.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.\n", teamName);
                            break;
                        }
                        teamMap.get(teamName).removePlayer(playerToRemove);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "Rating":
                    String teamToRate = command[1];

                    if (!teamMap.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.\n", teamName);
                        break;
                    }
                    double rating = teamMap.get(teamToRate).getRating();
                    System.out.printf("%s - %d\n", teamName, Math.round(rating));

                    break;
            }
            input = scanner.nextLine();
        }
    }
}
