package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.Car;
import softuni.exam.models.importDto.CarImportDto;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private static final String CAR_FILE_PATH = "src/main/resources/files/json/cars.json";

    private final CarRepository carRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.carRepository = carRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(CAR_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder sb = new StringBuilder();
        CarImportDto[] cars = gson.fromJson(readCarsFileContent(), CarImportDto[].class);

        return Arrays.stream(cars)
                .map(this::importCar)
                .collect(Collectors.joining("\n"));
    }

    private String importCar(CarImportDto dto) {
        boolean isValid = validationUtil.isValid(dto);
        Optional<Car> uniqueCar = carRepository.findByMakeModelAndKilometers(dto.getMake(), dto.getModel(), dto.getKilometers());
        if (uniqueCar.isPresent()) {
            isValid = false;
        }
        if (!isValid) {
            return "Invalid Car";
        }
        Car car = modelMapper.map(dto, Car.class);
        carRepository.save(car);
        return "Successfully imported car - " + dto.getMake() + " - " + dto.getModel();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        StringBuilder sb = new StringBuilder();
        List<Car> cars = carRepository.findByPictureCountDescThenByMake();
        cars.forEach(c -> {
            sb.append("Car make - ").append(c.getMake()).append(", model - ").append(c.getModel()).append(System.lineSeparator());
            sb.append("  Kilometers - ").append(c.getKilometers()).append(System.lineSeparator());
            sb.append("  Registered on - ").append(c.getRegisteredOn()).append(System.lineSeparator());
            sb.append("  Number of pictures - ").append(c.getPictures().size()).append(System.lineSeparator());
        });

        return sb.toString().trim();
    }

    @Override
    public Car getById(Long id) {
        return carRepository.getOne(id);
    }
}
