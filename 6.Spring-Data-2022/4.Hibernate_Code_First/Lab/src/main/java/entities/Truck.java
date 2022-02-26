package entities;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "trucks")
public class Truck extends Vehicle {
    private static final String TYPE = "Truck";

    private Double loadCapacity;

    @ManyToMany
    private Set<Driver> drivers;

    public Truck() {
    }

    public Truck(String model, BigDecimal price, String fuelType, Double loadCapacity) {
        super(TYPE, model, price, fuelType);
        this.loadCapacity = loadCapacity;
    }

    public Double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(Double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
