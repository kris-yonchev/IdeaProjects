package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.importDtoJSON.PictureImportDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {
    private static final String PICTURE_IMPORT_PATH = "src/main/resources/files/pictures.json";

    private final PictureRepository pictureRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURE_IMPORT_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        PictureImportDto[] pictureImportDtos = gson.fromJson(readFromFileContent(), PictureImportDto[].class);


        return Arrays.stream(pictureImportDtos)
                .map(this::importPicture)
                .collect(Collectors.joining("\n"));
    }

    private String importPicture(PictureImportDto dto) {
        boolean isValid = validationUtil.isValid(dto);
        if (!isValid) {
            return "Invalid Picture";
        }
        Optional<Picture> pictureByPath = pictureRepository.findByPath(dto.getPath());
        if (pictureByPath.isPresent()) {
            return "Invalid Picture";
        }
        Picture picture = modelMapper.map(dto, Picture.class);
        pictureRepository.save(picture);
        return String.format("Successfully imported Picture, with size %.2f", picture.getSize());
    }

    @Override
    public String exportPictures() {
        StringBuilder sb = new StringBuilder();
        List<Picture> pictures = pictureRepository.findAllBySizeGreaterThanOrderBySizeAsc(30000);

        pictures.forEach(p -> {
            sb.append(String.format("%.2f - %s", p.getSize(), p.getPath())).append(System.lineSeparator());
        });

        return sb.toString().trim();
    }
}
