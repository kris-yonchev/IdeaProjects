package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.Passenger;
import softuni.exam.models.importDtos.PassengerImportDto;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final static String PASSENGER_FILE_PATH = "src/main/resources/files/json/passengers.json";

    private final PassengerRepository passengerRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final TownService townService;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, TownService townService) {
        this.passengerRepository = passengerRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(Path.of(PASSENGER_FILE_PATH));
    }

    @Override
    public String importPassengers() throws IOException {
        StringBuilder sb = new StringBuilder();
        List<String> mails = new ArrayList<>();
        String importString = readPassengersFileContent();
        PassengerImportDto[] dtos = gson.fromJson(importString, PassengerImportDto[].class);
        List<Passenger> pasengers = Arrays.stream(dtos)
                .filter(dto -> {
                    boolean isValid = validationUtil.isValid(dto);
                    if (mails.contains(dto.getEmail()) ||
                            townService.findTownByName(dto.getTown()) == null) {
                        isValid = false;
                    } else {
                        mails.add(dto.getEmail());
                    }

                    if (!isValid) {
                        sb.append("Invalid Passenger\n");
                    } else {
//                        Successfully imported Passenger McKirdy - gmckirdy2@opensource.org
                        sb.append(String.format("Successfully imported Passenger %s - %s\n",
                                dto.getLastName(),
                                dto.getEmail()));
                    }
                    return isValid;
                }).map(p -> {
                    Passenger passenger = modelMapper.map(p, Passenger.class);
                    passenger.setTown(townService.findTownByName(p.getTown()));
                    return passenger;
                })
                .collect(Collectors.toList());
        passengerRepository.saveAll(pasengers);
        return sb.toString().trim();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {

        StringBuilder sb = new StringBuilder();

        List<String> p = passengerRepository.findAllAndOrderByTicketsCountDescThenByEmail();
        p.forEach(sh -> {
            String[] split = sh.split(",");
            sb.append(String.format("Passenger %s %s\n Email - %s\n\tPhone - %s\n Number of tickets - %d\n",
                    split[0],
                    split[1],
                    split[2],
                    split[3],
                    Integer.parseInt(split[4])));
        });

        return sb.toString().trim();
    }

    @Override
    public Passenger findByEmail(String email) {
        return passengerRepository.findByEmail(email);
    }
}
