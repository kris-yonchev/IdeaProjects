package com.example.demo.services;

import com.example.demo.entities.Supplier;
import com.example.demo.entities.dto.q3.LocalSupplierDto;

import java.io.IOException;
import java.util.List;

public interface SupplierService {

    void seedData() throws IOException;

    Supplier findRandom();

    List<LocalSupplierDto> getSupplierByImport();
}
