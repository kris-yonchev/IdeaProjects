package MultidimensionalArraysExercise;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double dmgPerTurn = Double.parseDouble(scanner.nextLine());
        int playerHp = 18500;
        double bossHp = 3000000;
        int playerPosRow = 7;
        int playerPosCol = 7;
        String lastSpell = "";


        while (playerHp > 0 || bossHp > 0) {
            if (playerHp>0) {
                bossHp-=dmgPerTurn;
            }
            if (lastSpell.equals("Cloud")) {
                playerHp -= 3500;
            }

            if (bossHp <= 0 || playerHp<=0) {
                break;
            }
            String[] spells = scanner.nextLine().split("\\s+");
            int row = Integer.parseInt(spells[1]);
            int col = Integer.parseInt(spells[2]);
            String spellName = spells[0];
            if (isStandingInFire(row, col, playerPosRow, playerPosCol)) {
                if (!isStandingInFire(row, col, playerPosRow - 1, playerPosCol) && !isWall(playerPosRow - 1)) {
                    playerPosRow--;
                    lastSpell = "";
                } else if (!isStandingInFire(row, col, playerPosRow, playerPosCol + 1) && !isWall(playerPosCol + 1)) {
                    playerPosCol++;
                    lastSpell = "";
                } else if (!isStandingInFire(row, col, playerPosRow + 1, playerPosCol) && !isWall(playerPosRow + 1)) {
                    playerPosRow++;
                    lastSpell = "";
                } else if (!isStandingInFire(row, col, playerPosRow, playerPosCol - 1) && !isWall(playerPosCol - 1)) {
                    playerPosCol--;
                    lastSpell = "";
                } else {
                    if (spellName.equals("Cloud")) {
                        playerHp -= 3500;
                        lastSpell = "Cloud";
                    } else if (spellName.equals("Eruption")) {
                        playerHp -= 6000;
                        lastSpell = "Eruption";
                    }
                }
            }
        }
        lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : "Eruption";
        String heiganState = bossHp <= 0 ? "Heigan: Defeated!" : String.format("Heigan: %.2f", bossHp);
        String playerState = playerHp <= 0 ? String.format("Player: Killed by %s", lastSpell) : String.format("Player: %d", playerHp);
        String playerLastSpot = String.format("Final position: %d, %d", playerPosRow, playerPosCol);
        System.out.println(heiganState);
        System.out.println(playerState);
        System.out.println(playerLastSpot);

    }

    private static boolean isWall(int i) {
        return i < 0 || i >= 15;
    }

    private static boolean isStandingInFire(int row, int col, int playerPosRow, int playerPosCol) {
        return (row - 1 <= playerPosRow && playerPosRow <= row + 1)
                && (col - 1 <= playerPosCol && playerPosCol <= col + 1);

    }
}
