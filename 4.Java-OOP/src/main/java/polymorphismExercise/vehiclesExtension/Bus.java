package polymorphismExercise.vehiclesExtension;

public class Bus extends Vehicle {
    private final static double WITH_PEOPLE = 1.4;

    public Bus(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    private final double BASE_BUS_CONSUMPTION = super.getFuelConsumption();


    public void changeConsumption(boolean isEmpty) {
        if (isEmpty) {
            super.setFuelConsumption(BASE_BUS_CONSUMPTION);
        } else {
            super.setFuelConsumption(BASE_BUS_CONSUMPTION + WITH_PEOPLE);
        }
    }
}
