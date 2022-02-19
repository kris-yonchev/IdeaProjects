package polymorphismExercise.vehiclesExtension;

public class Car extends Vehicle {
    private final static double AC_CONSUMPTION = 0.9;

    public Car(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AC_CONSUMPTION, tankCapacity);
    }


}
