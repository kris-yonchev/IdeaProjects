package com.example.demo.services;

import com.example.demo.entities.Supplier;
import com.example.demo.entities.dto.SupplierInputDto;
import com.example.demo.entities.dto.q3.LocalSupplierDto;
import com.example.demo.repositories.SupplierRepository;
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
public class SupplierServiceImpl implements SupplierService {

    private static final String SUPPLIER_FILE_STRING = "src/main/resources/files/suppliers.json";

    private final SupplierRepository supplierRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public SupplierServiceImpl(SupplierRepository supplierRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.supplierRepository = supplierRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedData() throws IOException {
        if (supplierRepository.count() > 0) {
            return;
        }

        Arrays.stream(gson.fromJson(Files.readString(Path.of(SUPPLIER_FILE_STRING)), SupplierInputDto[].class))
                .filter(validationUtil::isValid)
                .map(supplierInputDto -> modelMapper.map(supplierInputDto, Supplier.class))
                .forEach(supplierRepository::save);

    }

    @Override
    public Supplier findRandom() {
       return supplierRepository.findById(
                ThreadLocalRandom.current().nextLong(1, supplierRepository.count() + 1))
                .orElse(null);
    }

    @Override
    public List<LocalSupplierDto> getSupplierByImport() {
        return supplierRepository.getSuppliersWithImport0()
                .stream()
                .map(s -> {
                    LocalSupplierDto localSupplierDto = modelMapper.map(s, LocalSupplierDto.class);
                    localSupplierDto.setPartsCount(s.getParts().size());
                    return localSupplierDto;
                })
                .collect(Collectors.toList());
    }
}
