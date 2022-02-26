package entities;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Bike extends Vehicle {
    private static final String TYPE = "Bike";

    public Bike() {
    }

    public Bike(String model, BigDecimal price, String fuelType) {
        super(TYPE, model, price, fuelType);
    }
}
