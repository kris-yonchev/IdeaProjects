package softuni.exam.models.importDtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "planes")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneImportDto {

    @XmlElement(name = "plane")
    private List<PlaneInfoImportDto> planes;

    public PlaneImportDto() {
    }

    public List<PlaneInfoImportDto> getPlanes() {
        return planes;
    }

    public void setPlanes(List<PlaneInfoImportDto> planes) {
        this.planes = planes;
    }
}
