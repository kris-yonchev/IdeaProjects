package com.example.demo.entities.q4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarRootInfoDto {

    @XmlElement(name = "car")
    List<CarInfoDto> cars;

    public CarRootInfoDto() {
    }

    public List<CarInfoDto> getCars() {
        return cars;
    }

    public void setCars(List<CarInfoDto> cars) {
        this.cars = cars;
    }
}
