package softuni.exam.instagraphlite.models.ImportDtoXML;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "path")
@XmlAccessorType(XmlAccessType.FIELD)
public class PicturePathDto {

    @XmlElement(name = "path")
    @NotNull
    private String path;

    public PicturePathDto() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
