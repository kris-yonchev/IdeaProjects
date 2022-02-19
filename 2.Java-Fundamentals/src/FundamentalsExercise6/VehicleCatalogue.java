package FundamentalsExercise6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VehicleCatalogue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Car> cars = new ArrayList<>();

        while (!input.equals("End")) {
            String[] carInfo = input.split("\\s+");
            String carType = carInfo[0];
            String carModel = carInfo[1];
            String carColor = carInfo[2];
            int carPower = Integer.parseInt(carInfo[3]);
            Car car = new Car(carType, carModel, carColor, carPower);
            cars.add(car);

            input = scanner.nextLine();
        }
        while (!input.equals("Close the Catalogue")) {
            String modelToDisplay = input;
            cars.stream().filter(e -> e.getModel().equals(modelToDisplay)).forEach(System.out::println);


            input = scanner.nextLine();
        }
        System.out.printf("Cars have average horsepower of: %.2f.\n", average(cars.stream().filter(e->e.getType().equals("car")).collect(Collectors.toList())));
        System.out.printf("Trucks have average horsepower of: %.2f.\n", average(cars.stream().filter(e->e.getType().equals("truck")).collect(Collectors.toList())));
    }

    private static double average(List<Car> cars) {
        if (cars.size()==0) {
            return 0;
        }
        double sum = 0;
        for (Car car : cars) {
            sum+=car.getHorsePower();
        }
        return sum/cars.size();
    }


    public static class Car {
        private String type;
        private String model;
        private String color;
        private int horsePower;

        public Car(String type, String model, String color, int horsePower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsePower() {
            return horsePower;
        }

        @Override
        public String toString() {
            return String.format("Type: %s\n" + "Model: %s\n" + "Color: %s\n" + "Horsepower: %d", getType().toUpperCase().charAt(0) + this.getType().substring(1), getModel(), getColor(), getHorsePower());
        }
    }

}
