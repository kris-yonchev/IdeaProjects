package DefiningClassesExercise.SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            String carModel = info[0];
            int  carFuel = Integer.parseInt(info[1]);
            double carFuelCost = Double.parseDouble(info[2]);

            Car car = new Car(carModel, carFuel, carFuelCost);
            cars.put(carModel, car);
        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] data =  input.split("\\s+");
            String carModel = data[1];
            double distance = Double.parseDouble(data[2]);
            Car car = cars.get(carModel);

            if (!car.drive(distance)) {
                System.out.println("Insufficient fuel for the drive");
            }

            input = scanner.nextLine();
        }

        cars.values().forEach(System.out::println);
    }
}
