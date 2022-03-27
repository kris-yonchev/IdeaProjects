package softuni.exam.instagraphlite.models.ImportDtoXML;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "post")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostImportDto {

    @XmlElement(name = "caption")
    @NotNull
    @Size(min = 21)
    private String caption;

    @XmlElement(name = "user")
    private UsernameDto username;

    @XmlElement(name = "picture")
    private PicturePathDto path;

    public PostImportDto() {
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public UsernameDto getUsername() {
        return username;
    }

    public void setUsername(UsernameDto username) {
        this.username = username;
    }

    public PicturePathDto getPath() {
        return path;
    }

    public void setPath(PicturePathDto path) {
        this.path = path;
    }
}
