package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.XmlImportDto.PictureRootDto;
import softuni.exam.domain.entities.XmlImportDto.PictureRootImportDto;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidatorUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {
    private static final String PICTURE_FILE_PATH = "src/main/resources/files/xml/pictures.xml";

    private final PictureRepository pictureRepository;
    private final FileUtil fileUtil;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, FileUtil fileUtil, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.pictureRepository = pictureRepository;
        this.fileUtil = fileUtil;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public String importPictures() throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(PictureRootImportDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        PictureRootImportDto pictureRootImportDto = (PictureRootImportDto) unmarshaller.unmarshal(new FileReader(PICTURE_FILE_PATH));

        return pictureRootImportDto.getPictures().stream()
                .map(this::importPicture)
                .collect(Collectors.joining("\n"));
    }

    private String importPicture(PictureRootDto dto) {
        boolean isValid = validatorUtil.isValid(dto);
        if (!isValid) {
            return "Invalid Picture";
        }
        Picture picture = modelMapper.map(dto, Picture.class);
        pictureRepository.save(picture);
        return "Successfully imported picture - " + dto.getUrl();
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        return fileUtil.readFile(PICTURE_FILE_PATH);
    }

}
