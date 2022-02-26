package entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Plane extends Vehicle {
    private static final String TYPE = "Plane";

    private Integer passengerCapacity;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    public Plane() {
    }

    public Plane(String model, BigDecimal price, String fuelType, Integer passengerCapacity) {
        super(TYPE, model, price, fuelType);
        this.passengerCapacity = passengerCapacity;
    }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
