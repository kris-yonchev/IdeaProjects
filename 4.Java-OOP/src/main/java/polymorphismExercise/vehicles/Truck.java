package polymorphismExercise.vehicles;

public class Truck extends Vehicle {

    public Truck(Double fuelQuantity, Double fuelConsumption) {

        super(fuelQuantity, fuelConsumption + 1.6);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
