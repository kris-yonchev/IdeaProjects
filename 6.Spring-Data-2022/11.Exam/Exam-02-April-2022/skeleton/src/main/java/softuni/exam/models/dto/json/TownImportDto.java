package softuni.exam.models.dto.json;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class TownImportDto {

    @Size(min = 2)
    private String townName;

    @Positive
    private Integer population;

    public TownImportDto() {
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}
