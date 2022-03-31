package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;
import softuni.exam.domain.entities.XmlImportDto.TeamImportDto;
import softuni.exam.domain.entities.XmlImportDto.TeamRootImportDto;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidatorUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {
    private static final String TEAM_FILE_PATH = "src/main/resources/files/xml/teams.xml";

    private final ValidatorUtil validatorUtil;
    private final TeamRepository teamRepository;
    private final FileUtil fileUtil;
    private final ModelMapper modelMapper;
    private final PictureRepository pictureRepository;

    @Autowired
    public TeamServiceImpl(ValidatorUtil validatorUtil, TeamRepository teamRepository, FileUtil fileUtil, ModelMapper modelMapper, PictureRepository pictureRepository) {
        this.validatorUtil = validatorUtil;
        this.teamRepository = teamRepository;
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public String importTeams() throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(TeamRootImportDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        TeamRootImportDto teamRootImportDto = (TeamRootImportDto) unmarshaller.unmarshal(new FileReader(TEAM_FILE_PATH));

        return teamRootImportDto.getTeams()
                .stream()
                .map(this::importTeam)
                .collect(Collectors.joining("\n"));
    }

    private String importTeam(TeamImportDto dto) {
        boolean isValid = validatorUtil.isValid(dto);

        Optional<Picture> byUrl = pictureRepository.findByUrl(dto.getPicture().getUrl());
        if (byUrl.isEmpty()) {
            isValid = false;
        }

        if (!isValid) {
            return "Invalid Team";
        }

        Team team = modelMapper.map(dto, Team.class);
        team.setPicture(byUrl.get());
        teamRepository.save(team);
        return "Successfully imported - " + dto.getName();
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return fileUtil.readFile(TEAM_FILE_PATH);
    }
}
