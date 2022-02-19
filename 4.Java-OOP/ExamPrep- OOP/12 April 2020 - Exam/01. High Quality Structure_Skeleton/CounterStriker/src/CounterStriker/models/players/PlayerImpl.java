package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.setGun(gun);
        this.setAlive();
    }

    protected void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    protected void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    protected void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    protected void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    protected void setAlive() {
        this.isAlive = this.health > 0;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void takeDamage(int points) {
        if (this.armor >= points) {
            setArmor(this.armor - points);
        } else {
            int excessPoints = points - this.armor;
            setArmor(0);
            if (excessPoints >= getHealth()) {
                setHealth(0);
                isAlive = false;
            } else {
                setHealth(getHealth() - excessPoints);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n" +
                        "--Health: %d%n" +
                        "--Armor: %d%n" +
                        "--Gun: %s",
                this.getClass().getSimpleName(), this.getUsername(), this.getHealth(),
                this.getArmor(), this.getGun().getName());
    }
}
