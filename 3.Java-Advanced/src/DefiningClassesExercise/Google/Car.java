package DefiningClassesExercise.Google;

public class Car {
    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }
    public String format() {
        return String.format("%s %d", model, speed);
    }
}
