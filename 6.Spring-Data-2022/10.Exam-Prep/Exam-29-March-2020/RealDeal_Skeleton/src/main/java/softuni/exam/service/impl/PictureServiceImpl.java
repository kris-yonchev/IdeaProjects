package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.Picture;
import softuni.exam.models.importDto.PictureImportDto;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {
    private static final String PICTURE_FILE_PATH = "src/main/resources/files/json/pictures.json";

    private final PictureRepository pictureRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final CarService carService;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, CarService carService) {
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.carService = carService;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString(Path.of(PICTURE_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        PictureImportDto[] pictureImportDtos = gson.fromJson(readPicturesFromFile(), PictureImportDto[].class);
        return Arrays.stream(pictureImportDtos)
                .map(this::importPicture)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public Set<Picture> findByCarId(Long id) {
        return pictureRepository.findByCarId(id);
    }

    private String importPicture(PictureImportDto dto) {
        boolean isValid = validationUtil.isValid(dto);
        Optional<Picture> uniqueName = pictureRepository.findByName(dto.getName());
        if (uniqueName.isPresent()) {
            isValid = false;
        }

        if (!isValid) {
            return "Invalid Picture";
        }

        Picture picture = modelMapper.map(dto, Picture.class);
        picture.setCar(carService.getById(dto.getCar()));
        pictureRepository.save(picture);
        return "Successfully imported picture - " + dto.getName();
    }
}
