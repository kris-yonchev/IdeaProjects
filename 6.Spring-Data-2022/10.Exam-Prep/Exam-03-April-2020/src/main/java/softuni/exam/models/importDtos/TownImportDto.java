package softuni.exam.models.importDtos;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class TownImportDto {

    @Size(min = 2)
    private String name;

    @Positive
    private Integer population;

    private String guide;

    public TownImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }
}
