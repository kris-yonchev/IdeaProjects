package com.example.demo.entities.q4;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarInfoDto {

    @XmlAttribute
    private String make;

    @XmlAttribute
    private String model;

    @XmlAttribute(name = "travelled-distance")
    private String travelledDistance;

    @XmlElement(name = "parts")
    PartRootInfoDto parts;

    public CarInfoDto() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(String travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public PartRootInfoDto getParts() {
        return parts;
    }

    public void setParts(PartRootInfoDto parts) {
        this.parts = parts;
    }
}
