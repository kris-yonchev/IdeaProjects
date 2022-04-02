package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xml.ApartmentImportDto;
import softuni.exam.models.dto.xml.ApartmentRootImportDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private static final String APARTMENT_FILE_PATH = "src/main/resources/files/xml/apartments.xml";

    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final ApartmentRepository apartmentRepository;
    private final TownRepository townRepository;

    @Autowired
    public ApartmentServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper,
                                ApartmentRepository apartmentRepository, TownRepository townRepository) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.apartmentRepository = apartmentRepository;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(APARTMENT_FILE_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ApartmentRootImportDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        ApartmentRootImportDto apartmentRootImportDto =
                (ApartmentRootImportDto) unmarshaller.unmarshal(new FileReader(APARTMENT_FILE_PATH));

        return apartmentRootImportDto.getApartments().stream()
                .map(this::importApartment)
                .collect(Collectors.joining("\n"));
    }

    private String importApartment(ApartmentImportDto dto) {
        boolean isValid = validationUtil.isValid(dto);
        Optional<Apartment> byNameAndArea = apartmentRepository.findByTownNameAndArea(dto.getTown(), dto.getArea());
        if (byNameAndArea.isPresent()) {
            isValid = false;
        }

        if (!isValid) {
            return "Invalid apartment";
        }

        Apartment apartment = modelMapper.map(dto, Apartment.class);
        Optional<Town> town = townRepository.findByTownName(dto.getTown());
        apartment.setTown(town.get());
        apartmentRepository.save(apartment);
        return "Successfully imported apartment " + dto.getApartmentType() + " - " + dto.getArea();
    }
}
