package encapsulationExercise.footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> list;

    public Team(String name) {
        this.setName(name);
        this.list = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public void addPlayer(Player player) {
        this.list.add(player);
    }

    public void removePlayer(String player) {
        boolean isRemoved = this.list.removeIf(e -> e.getName().equals(player));
        if (!isRemoved) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", player, this.name));
        }
    }

    public double getRating() {
        return this.list.stream().mapToDouble(Player::overallSkillLevel).sum();
    }

}
