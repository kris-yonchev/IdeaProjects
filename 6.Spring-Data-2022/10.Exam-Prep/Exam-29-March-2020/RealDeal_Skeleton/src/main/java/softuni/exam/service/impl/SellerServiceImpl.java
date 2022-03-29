package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.Seller;
import softuni.exam.models.importDto.SellerImportDto;
import softuni.exam.models.importDto.SellerRootImportDto;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SellerServiceImpl implements SellerService {
    private static final String SELLER_FILE_PATH = "src/main/resources/files/xml/sellers.xml";

    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public SellerServiceImpl(SellerRepository sellerRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(SELLER_FILE_PATH));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(SellerRootImportDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        SellerRootImportDto sellerRootImportDto = (SellerRootImportDto) unmarshaller.unmarshal(new FileReader(SELLER_FILE_PATH));


        return sellerRootImportDto
                .getSellers()
                .stream()
                .map(this::importSeller)
                .collect(Collectors.joining("\n"));
    }

    private String importSeller(SellerImportDto dto) {
        boolean isValid = validationUtil.isValid(dto);
        Optional<Seller> byEmail = sellerRepository.findByEmail(dto.getEmail());
        if (byEmail.isPresent()) {
            isValid = false;
        }
        if (!isValid) {
            return "Invalid Seller";
        }

        Seller seller = modelMapper.map(dto, Seller.class);
        sellerRepository.save(seller);
        return "Successfully imported seller " + dto.getLastName() + " - " + dto.getEmail();
    }
}
