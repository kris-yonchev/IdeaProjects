package DefiningClassesExercise.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int engineCount = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engines = new HashMap<>();
        for (int i = 0; i < engineCount; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            String model = info[0];
            int power = Integer.parseInt(info[1]);
            Engine engine = null;
            if (info.length == 2) {
                engine = new Engine(model, power);
            } else if (info.length == 4) {
                int displacement = Integer.parseInt(info[2]);
                String efficiency = info[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else if (info.length == 3) {
                try {
                    int displacement = Integer.parseInt(info[2]);
                    engine = new Engine(model, power, displacement);
                } catch (NumberFormatException e) {
                    String efficiency = info[2];
                    engine = new Engine(model, power, efficiency);
                }
            }
            engines.put(model, engine);
        }
        List<Car> cars = new ArrayList<>();
        int carsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < carsCount; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String model = carInfo[0];
            String engineModel = carInfo[1];
            Engine carEngine = engines.get(engineModel);
            Car car = null;
            if (carInfo.length == 2) {
                car = new Car(model, carEngine);
            } else if (carInfo.length == 4) {
                int weight = Integer.parseInt(carInfo[2]);
                String color = carInfo[3];
                car = new Car(model, carEngine, weight, color);
            } else {
                try {
                    int weight = Integer.parseInt(carInfo[2]);
                    car = new Car(model, carEngine, weight);
                } catch (NumberFormatException e) {
                    String color = carInfo[2];
                    car = new Car(model, carEngine, color);
                }
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);
    }
}
