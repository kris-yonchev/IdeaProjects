package DefiningClassesExercise.Google;

public class Kids {
    private String name;
    private String bd;

    public Kids(String name, String bd) {
        this.name = name;
        this.bd = bd;
    }
    public String format() {
        return String.format("%s %s", name, bd);
    }
}
