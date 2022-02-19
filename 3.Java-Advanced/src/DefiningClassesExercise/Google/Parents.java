package DefiningClassesExercise.Google;

public class Parents {
    private String name;
    private String bd;

    public Parents(String name, String bd) {
        this.name = name;
        this.bd = bd;
    }
    public String format() {
        return String.format("%s %s", name, bd);
    }
}
