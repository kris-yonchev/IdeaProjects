package softuni.exam.domain.entities.XmlImportDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "pictures")
@XmlAccessorType(XmlAccessType.FIELD)
public class PictureRootImportDto {

    @XmlElement(name = "picture")
    private List<PictureRootDto> pictures;

    public PictureRootImportDto() {
    }

    public List<PictureRootDto> getPictures() {
        return pictures;
    }

    public void setPictures(List<PictureRootDto> pictures) {
        this.pictures = pictures;
    }
}
