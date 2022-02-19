package DefiningClassesExercise.CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = 0;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    @Override
    public String toString() {
        String printWeight;
        if (weight == 0) {
            printWeight = "n/a";
        } else {
            printWeight = weight + "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(model).append(":").append("\n").append(engine.toString()).append("\n")
                .append("Weight: "+printWeight).append("\n")
                .append("Color: "+color);
        return sb.toString();

    }
}
