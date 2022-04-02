package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.TownImportDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TownServiceImpl implements TownService {
    private static final String TOWN_FILE_PATH = "src/main/resources/files/json/towns.json";

    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final TownRepository townRepository;

    @Autowired
    public TownServiceImpl(ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper, TownRepository townRepository) {
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWN_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        TownImportDto[] townImportDtos = gson.fromJson(readTownsFileContent(), TownImportDto[].class);

        return Arrays.stream(townImportDtos)
                .map(this::importTown)
                .collect(Collectors.joining("\n"));
    }

    private String importTown(TownImportDto dto) {
        boolean isValid = validationUtil.isValid(dto);
        Optional<Town> townByTownName = townRepository.findByTownName(dto.getTownName());
        if (townByTownName.isPresent()) {
            isValid = false;
        }

        if (!isValid) {
            return "Invalid town";
        }

        Town town = modelMapper.map(dto, Town.class);
        townRepository.save(town);
        return "Successfully imported town " + dto.getTownName() + " - " + dto.getPopulation();
    }
}
