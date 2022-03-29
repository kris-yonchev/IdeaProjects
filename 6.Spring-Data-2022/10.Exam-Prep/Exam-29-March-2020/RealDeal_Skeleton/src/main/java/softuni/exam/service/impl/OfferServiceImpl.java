package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.Offer;
import softuni.exam.models.importDto.OfferImportDto;
import softuni.exam.models.importDto.OfferRootImportDto;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private static final String OFFER_FILE_PATH = "src/main/resources/files/xml/offers.xml";

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final PictureService pictureService;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, PictureService pictureService) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.pictureService = pictureService;
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


        return offerRootImportDto
                .getOffers()
                .stream()
                .map(this::importOffer)
                .collect(Collectors.joining("\n"));
    }

    private String importOffer(OfferImportDto dto) {
        boolean isValid = validationUtil.isValid(dto);
        Optional<Offer> byDescAndAddedOn = offerRepository.findByDescriptionAndAddedOn(dto.getDescription(),
                LocalDateTime.parse(dto.getAddedOn(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        if (byDescAndAddedOn.isPresent()) {
            isValid = false;
        }
        if (!isValid) {
            return "Invalid Offer";
        }

        Offer offer = modelMapper.map(dto, Offer.class);
        offer.setPictures(pictureService.findByCarId(offer.getCar().getId()));
        offerRepository.save(offer);
        return "Successfully imported offer " + offer.getAddedOn() + " - " + offer.isHasGoldStatus();
    }
}
