package com.example.demo.services;

import com.example.demo.entities.Car;
import com.example.demo.entities.q2.CarRootToyotaDto;
import com.example.demo.entities.q4.CarRootInfoDto;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface CarService {

    void seedData() throws IOException, JAXBException;

    Car getRandomCar();

    CarRootToyotaDto getAllByMaker();

    CarRootInfoDto getAllCarsWithParts();
}
