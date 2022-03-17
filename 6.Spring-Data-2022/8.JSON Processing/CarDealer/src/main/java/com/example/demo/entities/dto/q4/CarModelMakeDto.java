package com.example.demo.entities.dto.q4;

import com.google.gson.annotations.Expose;

import java.util.List;

public class CarModelMakeDto {

    @Expose
    private CarInfoDto car;

    @Expose
    private List<PartNamePriceDto> parts;

    public CarModelMakeDto() {
    }

    public CarInfoDto getCar() {
        return car;
    }

    public void setCar(CarInfoDto car) {
        this.car = car;
    }

    public List<PartNamePriceDto> getParts() {
        return parts;
    }

    public void setParts(List<PartNamePriceDto> parts) {
        this.parts = parts;
    }
}
