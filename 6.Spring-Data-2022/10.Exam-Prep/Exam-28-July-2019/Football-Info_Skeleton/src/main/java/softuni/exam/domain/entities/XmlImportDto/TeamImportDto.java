package softuni.exam.domain.entities.XmlImportDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "team")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamImportDto {

    @XmlElement
    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @XmlElement
    @NotNull
    private PictureRootDto picture;

    public TeamImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PictureRootDto getPicture() {
        return picture;
    }

    public void setPicture(PictureRootDto picture) {
        this.picture = picture;
    }
}
