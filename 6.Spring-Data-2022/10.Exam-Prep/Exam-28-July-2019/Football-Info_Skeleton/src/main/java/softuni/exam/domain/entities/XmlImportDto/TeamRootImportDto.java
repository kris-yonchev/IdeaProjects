package softuni.exam.domain.entities.XmlImportDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "teams")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamRootImportDto {

    @XmlElement(name = "team")
    private List<TeamImportDto> teams;

    public TeamRootImportDto() {
    }

    public List<TeamImportDto> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamImportDto> teams) {
        this.teams = teams;
    }
}
