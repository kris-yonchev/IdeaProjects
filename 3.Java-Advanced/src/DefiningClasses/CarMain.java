package DefiningClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] carInfo = scanner.nextLine().split("\\s+");

            Car car;
            if (carInfo.length == 1) {
                car = new Car(carInfo[0]);
            } else {
                car = new Car(carInfo[0], carInfo[1], Integer.parseInt(carInfo[2]));
            }

            cars.add(car);
        }

        for (Car car : cars) {
            System.out.print(car.toString());
        }

    }
}