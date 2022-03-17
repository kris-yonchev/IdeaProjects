package com.example.demo.services;

import com.example.demo.entities.Part;
import com.example.demo.entities.dto.PartInputDto;
import com.example.demo.repositories.PartRepository;
import com.example.demo.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class PartServiceImpl implements PartService {
    private final static String PART_FILE_LOCATION = "src/main/resources/files/parts.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final PartRepository partRepository;
    private final ValidationUtil validationUtil;
    private final SupplierService supplierService;

    public PartServiceImpl(ModelMapper modelMapper, Gson gson, PartRepository partRepository, ValidationUtil validationUtil, SupplierService supplierService) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.partRepository = partRepository;
        this.validationUtil = validationUtil;
        this.supplierService = supplierService;
    }

    @Override
    public void seedData() throws IOException {
        if (partRepository.count() > 0) {
            return;
        }

        List<PartInputDto> all = Arrays
                .stream(gson.fromJson(Files.readString(Path.of(PART_FILE_LOCATION)), PartInputDto[].class))
                .collect(Collectors.toList());

        for (PartInputDto partInputDto : all) {
            partInputDto.setSupplier(supplierService.findRandom());
        }

        all.stream()
                .filter(validationUtil::isValid)
                .map(p -> modelMapper.map(p, Part.class))
                .forEach(partRepository::save);

    }

    @Override
    public List<Part> getRandomParts() {
        int countOfParts = ThreadLocalRandom.current().nextInt(3, 6);
        long repoSize = partRepository.count();

        List<Part> parts = new ArrayList<>();

        for (int i = 0; i < countOfParts; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, repoSize + 1);
            parts.add(partRepository.findById(randomId).orElse(null));

        }
        return parts;
    }
}
