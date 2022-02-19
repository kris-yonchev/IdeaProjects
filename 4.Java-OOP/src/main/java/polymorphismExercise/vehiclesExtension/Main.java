package polymorphismExercise.vehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Vehicle> map = new LinkedHashMap<>();

        String[] info = scanner.nextLine().split("\\s+");
        Vehicle car = getVehicle(info);

        info = scanner.nextLine().split("\\s+");
        Vehicle truck = getVehicle(info);

        info = scanner.nextLine().split("\\s+");
        Vehicle bus = getVehicle(info);


        map.put("Car", car);
        map.put("Truck", truck);
        map.put("Bus", bus);


        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String action = command[0];
            String vehicle = command[1];
            double argument = Double.parseDouble(command[2]);
            Vehicle vehicleType = map.get(vehicle);
            try {
                switch (action) {
                    case "Drive":
                        if (vehicleType instanceof Bus) {
                            ((Bus) vehicleType).changeConsumption(false);
                        }
                        System.out.println(vehicleType.drive(argument));
                        break;
                    case "Refuel":
                        vehicleType.refuel(argument);
                        break;
                    case "DriveEmpty":
                        if (vehicleType instanceof Bus) {
                            ((Bus) vehicleType).changeConsumption(true);
                        }
                        System.out.println(vehicleType.drive(argument));
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        map.values().forEach(System.out::println);


    }

    private static Vehicle getVehicle(String[] vehicleInfo) {
        Vehicle vehicle = null;
        String vehicleType = vehicleInfo[0];
        double vehicleFuel = Double.parseDouble(vehicleInfo[1]);
        double vehicleCons = Double.parseDouble(vehicleInfo[2]);
        double vehicleCap = Double.parseDouble(vehicleInfo[3]);

        switch (vehicleType) {
            case "Bus":
                vehicle = new Bus(vehicleFuel, vehicleCons, vehicleCap);
                break;
            case "Car":
                vehicle = new Car(vehicleFuel, vehicleCons, vehicleCap);
                break;
            case "Truck":
                vehicle = new Truck(vehicleFuel, vehicleCons, vehicleCap);
                break;
            default:
                throw new IllegalArgumentException("No such vehicle!");
        }

        return vehicle;
    }
}
