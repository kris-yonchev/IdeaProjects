package com.example.demo.services;

import com.example.demo.entities.Car;
import com.example.demo.entities.dto.CarInputDto;
import com.example.demo.entities.dto.q2.CarFromMakeDto;
import com.example.demo.entities.dto.q4.CarInfoDto;
import com.example.demo.entities.dto.q4.CarModelMakeDto;
import com.example.demo.entities.dto.q4.PartNamePriceDto;
import com.example.demo.repositories.CarRepository;
import com.example.demo.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final static String CAR_FILE_PATH = "src/main/resources/files/cars.json";

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final CarRepository carRepository;
    private final ValidationUtil validationUtil;
    private final PartService partService;

    public CarServiceImpl(Gson gson, ModelMapper modelMapper, CarRepository carRepository, ValidationUtil validationUtil, PartService partService) {
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.carRepository = carRepository;
        this.validationUtil = validationUtil;
        this.partService = partService;
    }

    @Override
    public void seedData() throws IOException {
        if (carRepository.count() > 0) {
            return;
        }

        Arrays.stream(gson.fromJson(Files.readString(Path.of(CAR_FILE_PATH)), CarInputDto[].class))
                .filter(validationUtil::isValid)
                .map(c -> {
                    Car car = modelMapper.map(c, Car.class);
                    car.setParts(partService.getRandomParts());
                    return car;
                })
                .forEach(carRepository::save);
    }

    @Override
    public Car getRandomCar() {
        long repoSize = carRepository.count();
        long id = ThreadLocalRandom.current().nextLong(1, repoSize + 1);
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public List<CarFromMakeDto> getCarsFromMake() {
        return carRepository
                .findAllCarFromMake()
                .stream().map(c -> modelMapper.map(c, CarFromMakeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarModelMakeDto> getCarModelMakeParts() {
        return carRepository.findAll().stream().map(car -> {
            CarModelMakeDto carModelMakeDto = new CarModelMakeDto();
            carModelMakeDto.setCar(modelMapper.map(car, CarInfoDto.class));

            carModelMakeDto.setParts(car.getParts()
                    .stream()
                    .map(part -> modelMapper.map(part, PartNamePriceDto.class))
                    .collect(Collectors.toList()));
            return carModelMakeDto;
        })
                .collect(Collectors.toList());
    }
}
