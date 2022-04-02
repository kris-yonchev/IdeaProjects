package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.AgentImportDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgentServiceImpl implements AgentService {
    private static final String AGENT_FILE_PATH = "src/main/resources/files/json/agents.json";

    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final TownRepository townRepository;
    private final AgentRepository agentRepository;

    public AgentServiceImpl(ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper,
                            TownRepository townRepository, AgentRepository agentRepository) {
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.townRepository = townRepository;
        this.agentRepository = agentRepository;
    }

    @Override
    public boolean areImported() {
        return agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(AGENT_FILE_PATH));
    }

    @Override
    public String importAgents() throws IOException {
        AgentImportDto[] agentImportDtos = gson.fromJson(readAgentsFromFile(), AgentImportDto[].class);

        return Arrays.stream(agentImportDtos)
                .map(this::importAgent)
                .collect(Collectors.joining("\n"));
    }

    private String importAgent(AgentImportDto dto) {
        boolean isValid = validationUtil.isValid(dto);
        Optional<Town> townByName = townRepository.findByTownName(dto.getTown());
        if (townByName.isEmpty()) {
            isValid = false;
        }
        Optional<Agent> agentByFirstName = agentRepository.findByFirstName(dto.getFirstName());
        if (agentByFirstName.isPresent()) {
            isValid = false;
        }

        if (!isValid) {
            return "Invalid agent";
        }

        Agent agent = modelMapper.map(dto, Agent.class);
        agent.setTown(townByName.get());
        agentRepository.save(agent);
        return "Successfully imported agent - " + agent.getFirstName() + " " + agent.getLastName();
    }
}
