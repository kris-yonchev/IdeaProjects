package com.example.demo.services;

import com.example.demo.entities.Supplier;
import com.example.demo.entities.q3.SupplierInfoDto;
import com.example.demo.entities.q3.SupplierRootInfoDto;
import com.example.demo.entities.seedDto.supplier.SupplierRootDto;
import com.example.demo.repositories.SupplierRepository;
import com.example.demo.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    private static final String SUPPLIER_FILE_STRING = "src/main/resources/files/suppliers.xml";

    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedData() throws IOException, JAXBException {
        if (supplierRepository.count() > 0) {
            return;
        }

        JAXBContext jaxbContext = JAXBContext.newInstance(SupplierRootDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        SupplierRootDto supplierRootDto = (SupplierRootDto) unmarshaller.unmarshal(new FileReader(SUPPLIER_FILE_STRING));
        List<Supplier> suppliers = supplierRootDto
                .getSuppliers()
                .stream()
                .filter(validationUtil::validate)
                .map(s -> modelMapper.map(s, Supplier.class))
                .collect(Collectors.toList());
        supplierRepository.saveAll(suppliers);
    }

    @Override
    public Supplier findRandom() {
        return supplierRepository.findById(
                ThreadLocalRandom.current().nextLong(1, supplierRepository.count() + 1))
                .orElse(null);
    }

    @Override
    public SupplierRootInfoDto findAllSuppliersNotImporting() {
        List<Supplier> suppliers = supplierRepository.getSuppliersWithImport0();
        SupplierRootInfoDto supplierRootInfoDto = new SupplierRootInfoDto();
        supplierRootInfoDto.setSuppliers(suppliers.stream()
        .map(s -> {
           SupplierInfoDto supplierInfoDto = modelMapper.map(s, SupplierInfoDto.class);
            supplierInfoDto.setPartsCount(s.getParts().size());
            return supplierInfoDto;
        }).collect(Collectors.toList()));
        return supplierRootInfoDto;
    }

}
