package com.example.demo.services;

import com.example.demo.entities.Car;
import com.example.demo.entities.dto.q2.CarFromMakeDto;
import com.example.demo.entities.dto.q4.CarModelMakeDto;

import java.io.IOException;
import java.util.List;

public interface CarService {

    void seedData() throws IOException;

    Car getRandomCar();

    List<CarFromMakeDto> getCarsFromMake();

    List<CarModelMakeDto> getCarModelMakeParts();
}
