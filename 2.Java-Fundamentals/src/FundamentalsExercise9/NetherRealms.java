package FundamentalsExercise9;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split(",");
        Map<String, double[]> demonStats = new TreeMap<>();
        String dmgRegex = "(?:-|\\+|)\\d+(?:\\.*?\\d+)*";
        Pattern regex = Pattern.compile(dmgRegex);

        for (String name : names) {
            double dmg = 0.0;
            double hp = 0.0;
            String currentDemon = name.replaceAll(" ", "");
            dmg = getDmg(regex, dmg, currentDemon);
            hp = getHp(hp, currentDemon);
            demonStats.put(currentDemon, new double[]{hp, dmg});
        }

        for (Map.Entry<String, double[]> entry : demonStats.entrySet()) {
            String demonName = entry.getKey();
            double[] value = entry.getValue();
            int health = (int) value[0];
            double damage = value[1];

            System.out.printf("%s - %d health, %.2f damage\n", demonName, health, damage);
        }

    }

    private static double getHp(double hp, String demonName) {
        for (int i = 0; i < demonName.length(); i++) {
            char a = demonName.charAt(i);
            if (a != '+' && a != '-' && a != '*' && a != '/' && a != '.' && !Character.isDigit(a)) {
                hp += a;
            }
        }
        return hp;
    }

    private static double getDmg(Pattern regex, double dmg, String demonName) {
        Matcher matcher = regex.matcher(demonName);

        while (matcher.find()) {
            dmg += Double.parseDouble(matcher.group());
        }
        for (int i = 0; i < demonName.length(); i++) {
            char symbol = demonName.charAt(i);
            if (symbol == 42) {
                dmg *= 2;
            } else if (symbol == 47) {
                dmg /= 2;
            }
        }

        return dmg;
    }
}
