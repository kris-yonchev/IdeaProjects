package encapsulationExercise.footballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name == null) {
            this.name = name.trim();
        } else {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }

    public String getName() {
        return name;
    }

    private void setEndurance(int endurance) {
        statIsInRange(endurance, "Endurance");
        this.endurance = endurance;

    }

    private void setSprint(int sprint) {
        statIsInRange(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        statIsInRange(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        statIsInRange(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        statIsInRange(shooting, "Shooting");
        this.shooting = shooting;
    }

    public double overallSkillLevel() {
        return (this.shooting + this.sprint + this.dribble + this.passing + this.endurance) / 5.0;
    }

    private void statIsInRange(int stat, String statName) {
        if (stat < 0 || stat > 100) {
            throw new IllegalArgumentException(statName + " should be between 0 and 100.");
        }
    }
}
