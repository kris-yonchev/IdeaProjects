package com.example.demo.services;

import com.example.demo.entities.Part;
import com.example.demo.entities.seedDto.part.PartRootSeedDto;
import com.example.demo.entities.seedDto.part.PartSeedDto;
import com.example.demo.repositories.PartRepository;
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
public class PartServiceImpl implements PartService {
    private final static String PART_FILE_LOCATION = "src/main/resources/files/parts.xml";

    private final ModelMapper modelMapper;
    private final PartRepository partRepository;
    private final ValidationUtil validationUtil;
    private final SupplierService supplierService;

    public PartServiceImpl(ModelMapper modelMapper, PartRepository partRepository, ValidationUtil validationUtil, SupplierService supplierService) {
        this.modelMapper = modelMapper;
        this.partRepository = partRepository;
        this.validationUtil = validationUtil;
        this.supplierService = supplierService;
    }

    @Override
    public void seedData() throws IOException, JAXBException {
        if (partRepository.count() > 0) {
            return;
        }
        JAXBContext jaxbContext = JAXBContext.newInstance(PartRootSeedDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        PartRootSeedDto partRootSeedDto = (PartRootSeedDto) unmarshaller.unmarshal(new FileReader(PART_FILE_LOCATION));
        List<Part> parts = partRootSeedDto.getParts()
                .stream()
                .filter(validationUtil::validate)
                .map(p -> {
                    Part part = modelMapper.map(p, Part.class);
                    part.setSupplier(supplierService.findRandom());
                    return part;
                })
                .collect(Collectors.toList());
        partRepository.saveAll(parts);
    }

    @Override
    public List<Part> getRandomParts() {
        int countOfParts = ThreadLocalRandom.current().nextInt(10, 21);
        long repoSize = partRepository.count();

        List<Part> parts = new ArrayList<>();

        for (int i = 0; i < countOfParts; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, repoSize + 1);
            parts.add(partRepository.findById(randomId).orElse(null));

        }
        return parts;
    }
}
