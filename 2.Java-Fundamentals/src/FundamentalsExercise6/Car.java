package FundamentalsExercise6;

public class Car {
    private String type;
    private String model;
    private String color;
    private int horsePower;

    public Car(String type, String model, String color, int horsePower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getHorsePower() {
        return horsePower;
    }
    @Override
    public String toString() {
        return String.format("Type: %s\n"+"Model: %s\n"+"Color: %s\n"+"Horsepower: %d", getType().toUpperCase().charAt(0)+ this.getType().substring(1), getModel(), getColor(), getHorsePower());
    }
}
