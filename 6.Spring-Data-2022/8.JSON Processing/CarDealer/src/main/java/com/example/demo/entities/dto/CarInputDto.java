package com.example.demo.entities.dto;

import com.example.demo.entities.Part;
import com.google.gson.annotations.Expose;

import java.util.List;

public class CarInputDto {

    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private String travelledDistance;

    @Expose
    private List<Part> parts;

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

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }
}
