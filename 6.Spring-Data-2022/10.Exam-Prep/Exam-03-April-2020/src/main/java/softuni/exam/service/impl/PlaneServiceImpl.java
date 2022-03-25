package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.Plane;
import softuni.exam.models.importDtos.PlaneImportDto;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaneServiceImpl implements PlaneService {
    private final static String PLANE_FILE_LOCATION = "src/main/resources/files/xml/planes.xml";

    private final PlaneRepository planeRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public PlaneServiceImpl(PlaneRepository planeRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.planeRepository = planeRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files.readString(Path.of(PLANE_FILE_LOCATION));
    }

    @Override
    public String importPlanes() throws JAXBException, IOException {
        StringBuilder sb = new StringBuilder();
        JAXBContext jaxbContext = JAXBContext.newInstance(PlaneImportDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        PlaneImportDto planeImportDto = (PlaneImportDto) unmarshaller.unmarshal(new FileReader(PLANE_FILE_LOCATION));
        List<String> regNumbers = new ArrayList<>();
        List<Plane> planes = planeImportDto.getPlanes().stream()
                .filter(dto -> {
                    boolean isValid = validationUtil.isValid(dto);
                    if (regNumbers.contains(dto.getRegisterNumber())) {
                        isValid = false;
                    } else {
                        regNumbers.add(dto.getRegisterNumber());
                    }

                    if (isValid) {
                        sb.append(String.format("Successfully imported Plane %s\n",
                                dto.getRegisterNumber()));
                    } else {
                        sb.append("Invalid Plane\n");
                    }
                    return isValid;
                })
                .map(p -> modelMapper.map(p, Plane.class))
                .collect(Collectors.toList());
        planeRepository.saveAll(planes);
        return sb.toString().trim();
    }

    @Override
    public Plane findByRegisterNumber(String number) {
        return planeRepository.findPlaneByRegisterNumber(number);
    }
}
