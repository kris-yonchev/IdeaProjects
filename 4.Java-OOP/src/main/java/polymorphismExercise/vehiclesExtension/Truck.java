package polymorphismExercise.vehiclesExtension;

public class Truck extends Vehicle {
    private static final double AC_CONSUMPTION = 1.6;
    private static final double REFILL_PERCENT = 0.95;

    public Truck(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {

        super(fuelQuantity, fuelConsumption + AC_CONSUMPTION, tankCapacity);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * REFILL_PERCENT);
    }
}
