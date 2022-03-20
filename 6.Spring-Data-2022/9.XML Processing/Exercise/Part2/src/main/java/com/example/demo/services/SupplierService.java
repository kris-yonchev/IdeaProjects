package com.example.demo.services;

import com.example.demo.entities.Supplier;
import com.example.demo.entities.q3.SupplierRootInfoDto;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface SupplierService {

    void seedData() throws IOException, JAXBException;

    Supplier findRandom();

    SupplierRootInfoDto findAllSuppliersNotImporting();
}
