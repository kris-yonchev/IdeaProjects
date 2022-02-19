package ExamPrep.guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    public List<Player> roster;
    public String name;
    public int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (capacity > roster.size()) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player p : roster) {
            if (p.getName().equals(name)) {
                roster.remove(p);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name) && player.getRank().equals("Trial")) {
                player.setRank("Member");
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player a : roster) {
            if (a.getName().equals(name) && !a.getRank().equals("Trial")) {
                a.setRank("Trial");
            }
        }
    }

    public int count() {
        return roster.size();
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> kicked = new ArrayList<>();
        for (Player s : roster) {
            if (s.getClazz().equals(clazz)) {
                kicked.add(s);
            }
        }
        Player[] arr = new Player[kicked.size()];
        for (int i = 0; i < kicked.size(); i++) {
            arr[i] = kicked.get(i);
            roster.remove(arr[i]);
        }
        return arr;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Players in the guild: ").append(this.name).append(":").append("\n");
        for (Player player : roster) {
            sb.append(player).append("\n");
        }
        return sb.toString().trim();
    }
}
