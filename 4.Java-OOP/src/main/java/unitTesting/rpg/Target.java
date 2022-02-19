package unitTesting.rpg;

public interface Target {
    void takeAttack(int attackPoints);
    int getHealth();
    int giveExperience();
    boolean isDead();
}
