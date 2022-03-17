package com.example.demo.entities.dto.q1;

import com.google.gson.annotations.Expose;

public class CarSaleDto {

    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private String travelledDistance;

    public CarSaleDto() {
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
}
