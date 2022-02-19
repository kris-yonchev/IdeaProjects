package DefiningClassesExercise.RawData;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
//            {Model}
//            {EngineSpeed} {EnginePower}
//            {CargoWeight} {CargoType}
//            {Tire1Pressure} {Tire1Age}
//            {Tire2Pressure} {Tire2Age}
//            {Tire3Pressure} {Tire3Age}
//            {Tire4Pressure} {Tire4Age}
            String carModel = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            double tirePressure1 = Double.parseDouble(data[5]);
            int tireAge1 = Integer.parseInt(data[6]);
            double tirePressure2 = Double.parseDouble(data[7]);
            int tireAge2 = Integer.parseInt(data[8]);
            double tirePressure3 = Double.parseDouble(data[9]);
            int tireAge3 = Integer.parseInt(data[10]);
            double tirePressure4 = Double.parseDouble(data[11]);
            int tireAge4 = Integer.parseInt(data[12]);
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire1 = new Tire(tirePressure1, tireAge1);
            Tire tire2 = new Tire(tirePressure2, tireAge2);
            Tire tire3 = new Tire(tirePressure3, tireAge3);
            Tire tire4 = new Tire(tirePressure4, tireAge4);
            Car car = new Car(carModel, engine, cargo, tire1, tire2, tire3, tire4);
            cars.put(carModel, car);
        }
        String command = scanner.nextLine();
        if (command.equals("fragile")) {
            for (Map.Entry<String, Car> car : cars.entrySet()) {
                if (car.getValue().getCargo().getType().equals("fragile")) {
                    for (Tire tire : car.getValue().getTires()) {
                        if (tire.getPressure() < 1) {
                            System.out.println(car.getKey());
                            break;
                        }
                    }
                }
            }
        } else {
            for (Map.Entry<String, Car> car : cars.entrySet()) {
                if (car.getValue().getCargo().getType().equals("flamable") && car.getValue().getEngine().getPower() > 250) {
                    System.out.println(car.getKey());
                }
            }

        }
    }
}
