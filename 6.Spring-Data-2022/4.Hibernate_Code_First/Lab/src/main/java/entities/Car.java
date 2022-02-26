package entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;


@Entity
@Table(name = "cars")
public class Car extends Vehicle {
    private static final String TYPE = "Car";

    private int seats;

    public Car() {
    }

    @OneToOne
    @JoinColumn(name = "plateNumber_id", referencedColumnName = "id")
    private PlateNumber plateNumber;



    public Car(String model, BigDecimal price, String fuelType, int seats) {
        super(TYPE, model, price, fuelType);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public PlateNumber getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(PlateNumber plateNumber) {
        this.plateNumber = plateNumber;
    }
}
