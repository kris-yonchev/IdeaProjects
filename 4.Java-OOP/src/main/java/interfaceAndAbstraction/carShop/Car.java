package interfaceAndAbstraction.carShop;

import java.io.Serializable;

public interface Car extends Serializable {
    Integer Tires = 4;

    String getModel();

    String getColor();

    Integer getHorsePower();

    String countryProduced();
}
