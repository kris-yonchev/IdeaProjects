package DefiningClassesExercise.Google;

public class Pokemon {
    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }
    public String format() {
        return String.format("%s %s", name, type);
    }
}
