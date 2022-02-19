package MidExamPrep;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hp = 100;
        int startingBitCoin = 0;
        int roomCounter = 0;
        boolean survivor = true;
        String[] rooms = scanner.nextLine().split("[ |]");
        for (int i = 0; i < rooms.length; i += 2) {
            if (rooms[i].equals("potion")) {
                roomCounter++;
                int potion = Integer.parseInt(rooms[i + 1]);
                int currentHp = hp;
                hp += potion;
                if (hp > 100) {
                    hp = 100;
                }
                int healing = hp - currentHp;

                System.out.printf("You healed for %d hp.\nCurrent health: %d hp.\n", healing, hp);
            } else if (rooms[i].equals("chest")) {
                roomCounter++;
                int coin = Integer.parseInt(rooms[i + 1]);
                startingBitCoin += coin;
                System.out.printf("You found %d bitcoins.\n", coin);
            } else {
                roomCounter++;
                int dmg = Integer.parseInt(rooms[i + 1]);
                if (dmg >= hp) {
                    survivor = false;
                    System.out.printf("You died! Killed by %s.\nBest room: %d", rooms[i], roomCounter);
                    return;
                }
                hp -= dmg;
                System.out.printf("You slayed %s.\n", rooms[i]);
            }


        }
        if (survivor) {

            System.out.printf("You've made it!\nBitcoins: %d\nHealth: %d", startingBitCoin, hp);
        }
    }
}
