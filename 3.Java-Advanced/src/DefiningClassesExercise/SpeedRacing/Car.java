package DefiningClassesExercise.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int distance;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distance = 0;
    }

    public boolean drive(double distance) {
        double fuelReq = distance * fuelCost;
        if (fuelReq > this.fuelAmount) {
            return false;
        } else {
            this.fuelAmount -= fuelReq;
            this.distance += distance;
            return true;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distance);
    }
}
