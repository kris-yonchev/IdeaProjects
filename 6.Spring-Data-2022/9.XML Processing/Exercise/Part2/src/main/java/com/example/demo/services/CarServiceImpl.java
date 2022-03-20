package com.example.demo.services;

import com.example.demo.entities.Car;
import com.example.demo.entities.q2.CarRootToyotaDto;
import com.example.demo.entities.q2.CarToyotaDto;
import com.example.demo.entities.q4.CarInfoDto;
import com.example.demo.entities.q4.CarRootInfoDto;
import com.example.demo.entities.q4.PartInfoDto;
import com.example.demo.entities.q4.PartRootInfoDto;
import com.example.demo.entities.seedDto.car.CarRootSeedDto;
import com.example.demo.repositories.CarRepository;
import com.example.demo.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final static String CAR_FILE_PATH = "src/main/resources/files/cars.xml";

    private final ModelMapper modelMapper;
    private final CarRepository carRepository;
    private final ValidationUtil validationUtil;
    private final PartService partService;

    public CarServiceImpl(ModelMapper modelMapper, CarRepository carRepository, ValidationUtil validationUtil, PartService partService) {
        this.modelMapper = modelMapper;
        this.carRepository = carRepository;
        this.validationUtil = validationUtil;
        this.partService = partService;
    }

    @Override
    public void seedData() throws IOException, JAXBException {
        if (carRepository.count() > 0) {
            return;
        }
        JAXBContext jaxbContext = JAXBContext.newInstance(CarRootSeedDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        CarRootSeedDto carRootSeedDto = (CarRootSeedDto) unmarshaller.unmarshal(new FileReader(CAR_FILE_PATH));
        List<Car> cars = carRootSeedDto.getCars()
                .stream()
                .filter(validationUtil::validate)
                .map(c -> {
                    Car car = modelMapper.map(c, Car.class);
                    car.setParts(partService.getRandomParts());
                    return car;
                })
                .collect(Collectors.toList());

        carRepository.saveAll(cars);
    }

    @Override
    public Car getRandomCar() {
        long repoSize = carRepository.count();
        long id = ThreadLocalRandom.current().nextLong(1, repoSize + 1);
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public CarRootToyotaDto getAllByMaker() {
        CarRootToyotaDto toyotas = new CarRootToyotaDto();
        toyotas.setCars(carRepository.findAllCarFromMake().stream()
                .map(c -> modelMapper.map(c, CarToyotaDto.class))
                .collect(Collectors.toList()));

        return toyotas;
    }

    @Override
    public CarRootInfoDto getAllCarsWithParts() {
        List<Car> cars = carRepository.findAll();
        CarRootInfoDto carRootInfoDto = new CarRootInfoDto();
        carRootInfoDto.setCars(cars.stream()
        .map(c -> {
            CarInfoDto carInfoDto = modelMapper.map(c, CarInfoDto.class);
            List<PartInfoDto> parts = c.getParts().stream().map(p -> modelMapper.map(p, PartInfoDto.class)).collect(Collectors.toList());
            PartRootInfoDto partRootInfoDto = new PartRootInfoDto();
            partRootInfoDto.setParts(parts);
            carInfoDto.setParts(partRootInfoDto);
            return carInfoDto;
        }).collect(Collectors.toList()));
        return carRootInfoDto;
    }
}
