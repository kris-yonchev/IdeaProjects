package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.Ticket;
import softuni.exam.models.importDtos.TicketRootImportDto;
import softuni.exam.repository.TicketRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.PlaneService;
import softuni.exam.service.TicketService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {
    private final static String TICKET_FILE_LOCATION = "src/main/resources/files/xml/tickets.xml";

    private final TicketRepository ticketRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final TownService townService;
    private final PlaneService planeService;
    private final PassengerService passengerService;


    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, ValidationUtil validationUtil, ModelMapper modelMapper, TownService townService, PlaneService planeService, PassengerService passengerService) {
        this.ticketRepository = ticketRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.townService = townService;
        this.planeService = planeService;
        this.passengerService = passengerService;
    }

    @Override
    public boolean areImported() {
        return ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(Path.of(TICKET_FILE_LOCATION));
    }

    @Override
    public String importTickets() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        JAXBContext jaxbContext = JAXBContext.newInstance(TicketRootImportDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        TicketRootImportDto ticketRootImportDto = (TicketRootImportDto) unmarshaller.unmarshal(new FileReader(TICKET_FILE_LOCATION));
        List<String> regNumbers = new ArrayList<>();
        List<Ticket> tickets = ticketRootImportDto.getTickets()
                .stream()
                .filter(dto -> {
                    boolean isValid = validationUtil.isValid(dto);
                    if (regNumbers.contains(dto.getSerialNumber())) {
                        isValid = false;
                    } else {
                        regNumbers.add(dto.getSerialNumber());
                    }

                    if (isValid) {
                        sb.append(String.format("Successfully imported Ticket %s - %s\n",
                                dto.getFromTown().getName(),
                                dto.getToTown().getName()));
                    } else {
                        sb.append("Invalid Ticket\n");
                    }

                    return isValid;
                })
                .map(t -> {
                    Ticket ticket = modelMapper.map(t, Ticket.class);
                    ticket.setFromTown(townService.findTownByName(t.getFromTown().getName()));
                    ticket.setTakeoff(LocalDateTime.parse(t.getTakeOff(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                    ticket.setToTown(townService.findTownByName(t.getToTown().getName()));
                    ticket.setPlane(planeService.findByRegisterNumber(t.getPlane().getRegisterNumber()));
                    ticket.setPassenger(passengerService.findByEmail(t.getPassenger().getEmail()));
                    return ticket;
                })
                .collect(Collectors.toList());
        ticketRepository.saveAll(tickets);
        return sb.toString().trim();
    }
}
