package ExamPrep.dealership;


import java.util.ArrayList;
import java.util.List;

public class Dealership {
    public List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.data = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (capacity > 0) {
            data.add(car);
            capacity--;
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer)) {
                if (car.getModel().equals(model)) {
                    data.remove(car);
                    return true;
                }
            }
        }
        return false;
    }

    public Car getLatestCar() {
        int latestYear = 0;
        Car car = null;
        for (Car c : data) {
            if (c.getYear() > latestYear) {
                latestYear = c.getYear();
                car = c;
            }
        }
        return car;
    }

    public Car getCar(String manufacturer, String model) {
        Car car = null;
        for (Car a : data) {
            if (a.getManufacturer().equals(manufacturer)) {
                if (a.getModel().equals(model)) {
                    car = a;
                }
            }
        }
        return car;
    }

    public int getCount() {
        return data.size();
    }

//    " The cars are in a car dealership {name}:

    public String getStatistics () {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are in a car dealership ").append(this.name).append(":").append("\n");
        for (Car p : data) {
            sb.append(p).append("\n");
        }
        return sb.toString();
    }
}
