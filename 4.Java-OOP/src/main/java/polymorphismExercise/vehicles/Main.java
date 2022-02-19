package polymorphismExercise.vehicles;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Vehicle> map = new HashMap<>();

        String[] carInfo = scanner.nextLine().split("\\s+");

        double carFuel = Double.parseDouble(carInfo[1]);
        double carCons = Double.parseDouble(carInfo[2]);
        Vehicle car = new Car(carFuel, carCons);
        map.put("Car", car);

        String[] truckInfo = scanner.nextLine().split("\\s+");

        double truckFuel = Double.parseDouble(truckInfo[1]);
        double truckCons = Double.parseDouble(truckInfo[2]);
        Vehicle truck = new Truck(truckFuel, truckCons);
        map.put("Truck", truck);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String action = command[0];
            String vehicle = command[1];
            double argument = Double.parseDouble(command[2]);
            if (action.equals("Drive")) {
                System.out.println(map.get(vehicle).drive(argument));
            } else {
                map.get(vehicle).refuel(argument);
            }
        }

        map.values().forEach(System.out::println);


    }
}
