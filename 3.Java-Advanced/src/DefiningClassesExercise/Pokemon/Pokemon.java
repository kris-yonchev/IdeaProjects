package DefiningClassesExercise.Pokemon;

public class Pokemon {
    private String name;
    private String element;
    private int hp;

    public Pokemon(String name, String element, int hp) {
        this.name = name;
        this.element = element;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public String getElement() {
        return element;
    }

    public int getHp() {
        return hp;
    }

}
