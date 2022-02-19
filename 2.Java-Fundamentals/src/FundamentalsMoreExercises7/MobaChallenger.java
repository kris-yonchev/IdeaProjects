package FundamentalsMoreExercises7;

import java.util.*;


public class MobaChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> players = new HashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("Season end")) {
            String[] info = input.split("\\s+");
            if (info[1].equals("vs")) {
                String player1 = info[0];
                String player2 = info[2];

                if (players.containsKey(player1) && players.containsKey(player2)) {
                    boolean hasCommon = false;
                    for (String s : players.get(player1).keySet()) {
                        for (String s1 : players.get(player2).keySet()) {
                            if (s.equals(s1)) {
                                hasCommon = true;
                                break;
                            }
                        }
                    }
                    if (hasCommon) {
                        if (players.get(player1).values().stream().mapToInt(i -> i).sum() >
                                players.get(player2).values().stream().mapToInt(i -> i).sum()) {
                            players.remove(player2);
                        } else if (players.get(player2).values().stream().mapToInt(i -> i).sum() >
                                players.get(player1).values().stream().mapToInt(i -> i).sum()) {
                            players.remove(player1);
                        }
                    }
                }

            } else {
                String[] info2 = input.split(" -> ");
                String playerName = info2[0];
                String playerRole = info2[1];
                int playerScore = Integer.parseInt(info2[2]);
                Map<String, Integer> roleAndPoints = new HashMap<>();
                roleAndPoints.put(playerRole, playerScore);

                players.putIfAbsent(playerName, roleAndPoints);
                players.get(playerName).putIfAbsent(playerRole, playerScore);

                if (players.get(playerName).get(playerRole) < playerScore) {
                    players.get(playerName).put(playerRole, playerScore);
                }

            }


            input = scanner.nextLine();
        }

        players.entrySet().stream().sorted((p1, p2) -> {
            int result = Integer.compare(p2.getValue().values().stream().mapToInt(i -> i).sum(), p1.getValue().values().stream().mapToInt(i -> i).sum());
            if (result == 0) {
                result = p1.getKey().compareTo(p2.getKey());
            }
            return result;
        })
                .forEach(entry -> {
                    System.out.printf("%s: %d skill\n", entry.getKey(), entry.getValue().values().stream().mapToInt(i -> i).sum());
                    entry.getValue().entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                            .forEach(e -> {
                                System.out.printf("- %s <::> %d\n", e.getKey(), e.getValue());
                            });
                });


    }
}
