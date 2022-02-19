package LastExamPrep;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> heroHp = new TreeMap<>();
        Map<String, Integer> heroMp = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] heroes = scanner.nextLine().split("\\s+");
            String name = heroes[0];
            int hp = Integer.parseInt(heroes[1]);
            int mp = Integer.parseInt(heroes[2]);
            if (hp <= 100) {
                heroHp.put(name, hp);
            }
            if (mp <= 200) {
                heroMp.put(name, mp);
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commands = input.split(" - ");
            String hero = commands[1];
            switch (commands[0]) {
                case "CastSpell":
                    int manaNeeded = Integer.parseInt(commands[2]);
                    String spellName = commands[3];
                    if (heroMp.get(hero) >= manaNeeded) {
                        heroMp.put(hero, heroMp.get(hero) - manaNeeded);
                        System.out.printf("%s has successfully cast %s and now has %d MP!\n", hero, spellName, heroMp.get(hero));
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!\n", hero, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(commands[2]);
                    String attacker = commands[3];
                    int hpLeft = heroHp.get(hero) - damage;
                    if (hpLeft > 0) {
                        heroHp.put(hero, hpLeft);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n", hero, damage, attacker, hpLeft);
                    } else {
                        System.out.printf("%s has been killed by %s!\n", hero, attacker);
                        heroHp.remove(hero);
                        heroMp.remove(hero);
                    }
                    break;
                case "Recharge":
                    int manaToRestore = Integer.parseInt(commands[2]);
                    int wasMp = heroMp.get(hero);
                    int currentMana = wasMp + manaToRestore;
                    if (currentMana > 200) {
                        currentMana = 200;
                    }
                    heroMp.put(hero, currentMana);
                    System.out.printf("%s recharged for %d MP!\n", hero, currentMana - wasMp);
                    break;
                case "Heal":
                    int healAmount = Integer.parseInt(commands[2]);
                    int wasHp = heroHp.get(hero);
                    int hpHealed = wasHp + healAmount;
                    if (hpHealed > 100) {
                        hpHealed = 100;
                    }
                    heroHp.put(hero, hpHealed);
                    System.out.printf("%s healed for %d HP!\n", hero, hpHealed - wasHp);
                    break;
            }
            input = scanner.nextLine();
        }
        heroHp.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> {
                    String heroicName = e.getKey();
                    System.out.printf("%s\n  HP: %d\n  MP: %d\n", heroicName, e.getValue(), heroMp.get(heroicName));
                });
    }
}
