package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xml.OfferImportDto;
import softuni.exam.models.dto.xml.OfferRootImportDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private static final String OFFER_FILE_PATH = "src/main/resources/files/xml/offers.xml";

    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final OfferRepository offerRepository;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;

    @Autowired
    public OfferServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper, OfferRepository offerRepository, AgentRepository agentRepository, ApartmentRepository apartmentRepository) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.offerRepository = offerRepository;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFER_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(OfferRootImportDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        OfferRootImportDto offerRootImportDto = (OfferRootImportDto) unmarshaller.unmarshal(new FileReader(OFFER_FILE_PATH));

        return offerRootImportDto.getOffers()
                .stream()
                .map(this::importOffer)
                .collect(Collectors.joining("\n"));
    }

    private String importOffer(OfferImportDto dto) {
        boolean isValid = validationUtil.isValid(dto);
        Optional<Agent> byName = agentRepository.findByFirstName(dto.getAgent().getName());
        if (byName.isEmpty()) {
            isValid = false;
        }

        if (!isValid) {
            return "Invalid offer";
        }

        Offer offer = modelMapper.map(dto, Offer.class);
        offer.setAgent(byName.get());
        Apartment byId = apartmentRepository.getById(dto.getApartment().getId());
        offer.setApartment(byId);
        offerRepository.save(offer);

        return String.format("Successfully imported offer %.2f", dto.getPrice());
    }

    @Override
    public String exportOffers() {
        StringBuilder sb = new StringBuilder();
        List<Offer> exportBestOffers = offerRepository.findByThreeRooms();

        exportBestOffers.forEach(o -> {
            sb.append("Agent ").append(o.getAgent().getFirstName()).append(" ").append(o.getAgent().getLastName())
                    .append(" with offer №").append(o.getId()).append(":").append(System.lineSeparator());
            sb.append("\t").append("-Apartment area: ").append(String.format("%.2f", o.getApartment().getArea())).append(System.lineSeparator());
            sb.append("\t").append("--Town: ").append(o.getApartment().getTown().getTownName()).append(System.lineSeparator());
            sb.append("\t").append("---Price: ").append(String.format("%.2f", o.getPrice())).append("$").append(System.lineSeparator());
        });

        return sb.toString().trim();
    }
}
