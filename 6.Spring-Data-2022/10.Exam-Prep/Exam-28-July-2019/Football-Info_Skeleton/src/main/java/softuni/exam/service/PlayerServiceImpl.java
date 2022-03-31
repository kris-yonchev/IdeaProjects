package softuni.exam.service;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.entities.JsonImportDto.PlayerImportDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Player;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidatorUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {
    private static final String PLAYER_FILE_PATH = "src/main/resources/files/json/players.json";

    private final PlayerRepository playerRepository;
    private final PictureRepository pictureRepository;
    private final TeamRepository teamRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final FileUtil fileUtil;
    private final ValidatorUtil validatorUtil;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, PictureRepository pictureRepository,
                             TeamRepository teamRepository, Gson gson, ModelMapper modelMapper,
                             FileUtil fileUtil, ValidatorUtil validatorUtil) {
        this.playerRepository = playerRepository;
        this.pictureRepository = pictureRepository;
        this.teamRepository = teamRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.fileUtil = fileUtil;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public String importPlayers() throws IOException {
        PlayerImportDto[] playerImportDtos = gson.fromJson(readPlayersJsonFile(), PlayerImportDto[].class);

        return Arrays.stream(playerImportDtos)
                .map(this::importPlayer)
                .collect(Collectors.joining("\n"));
    }

    private String importPlayer(PlayerImportDto dto) {
        boolean isValid = validatorUtil.isValid(dto);
        Optional<Picture> pictureByUrl = pictureRepository.findByUrl(dto.getPicture().getUrl());
        if (pictureByUrl.isEmpty()) {
            isValid = false;
        }
        Optional<Team> teamByName = teamRepository.findByName(dto.getTeam().getName());
        if (teamByName.isEmpty()) {
            isValid = false;
        }
        if (!isValid) {
            return "Invalid Player";
        }

        Player player = modelMapper.map(dto, Player.class);
        player.setPicture(pictureByUrl.get());
        player.setTeam(teamByName.get());
        playerRepository.save(player);
        return "Successfully imported player: " + dto.getFirstName() + " " + dto.getLastName();
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return fileUtil.readFile(PLAYER_FILE_PATH);
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        List<Player> players = playerRepository.findAllBySalaryGreaterThanOrderBySalaryDesc(BigDecimal.valueOf(100000));
        StringBuilder sb = new StringBuilder();
        players.forEach(p -> {
            sb.append("Player name: ")
                    .append(p.getFirstName()).append(" ").append(p.getLastName()).append(System.lineSeparator());
            sb.append("\t").append("Number: ").append(p.getNumber()).append(System.lineSeparator());
            sb.append("\t").append("Salary: ").append(p.getSalary()).append(System.lineSeparator());
            sb.append("\t").append("Team: ").append(p.getTeam().getName()).append(System.lineSeparator());
        });

        return sb.toString().trim();
    }

    @Override
    public String exportPlayersInATeam() {
        List<Player> players = playerRepository.findAllFromTeam();
        StringBuilder sb = new StringBuilder();
        sb.append("Team: North Hub").append(System.lineSeparator());
        players.forEach(p -> {
            sb.append("     ").append("Player name: ")
                    .append(p.getFirstName())
                    .append(" ")
                    .append(p.getLastName())
                    .append(" - ")
                    .append(p.getPosition()).append(System.lineSeparator());
            sb.append("     ").append("Number: ").append(p.getNumber()).append(System.lineSeparator());
        });

        return sb.toString().trim();
    }
}
