package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.Town;
import softuni.exam.models.importDtos.TownImportDto;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TownServiceImpl implements TownService {
    private final String TOWN_FILE_PATH = "src/main/resources/files/json/towns.json";

    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
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
        String towns = readTownsFileContent();
        StringBuilder sb = new StringBuilder();

        TownImportDto[] townImportDto = gson.fromJson(towns, TownImportDto[].class);
        List<String> names = new ArrayList<>();
        List<Town> townList = Arrays.stream(townImportDto)
                .filter(dto -> {
                            boolean isValid = validationUtil.isValid(dto);

                            if (names.contains(dto.getName())) {
                                isValid = false;
                            } else {
                                names.add(dto.getName());
                            }

                            if (!isValid) {
                                sb.append("Invalid Town\n");
                            } else {
//                        Successfully imported Town Paris - 3258941
                                sb.append("Successfully imported Town ")
                                        .append(dto.getName())
                                        .append(" - ")
                                        .append(dto.getPopulation())
                                        .append(System.lineSeparator());
                            }
                            return isValid;
                        }
                ).map(t -> modelMapper.map(t, Town.class))
                .collect(Collectors.toList());

        townRepository.saveAll(townList);
        return sb.toString().trim();
    }

    @Override
    public Town findTownByName(String name) {
        return townRepository.findByName(name);
    }
}
