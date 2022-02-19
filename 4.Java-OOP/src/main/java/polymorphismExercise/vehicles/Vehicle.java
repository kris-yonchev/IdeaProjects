package polymorphismExercise.vehicles;

import java.text.DecimalFormat;

public class Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumption;

    public Vehicle(Double fuelQuantity, Double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    public String drive(double distance) {
        double fuelNeeded = this.fuelConsumption * distance;
        if (this.fuelQuantity < fuelNeeded) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }
        this.fuelQuantity -= fuelNeeded;
        DecimalFormat df = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
