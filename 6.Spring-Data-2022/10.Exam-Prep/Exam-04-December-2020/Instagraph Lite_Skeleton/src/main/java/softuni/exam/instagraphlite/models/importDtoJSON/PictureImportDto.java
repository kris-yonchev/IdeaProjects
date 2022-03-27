package softuni.exam.instagraphlite.models.importDtoJSON;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PictureImportDto {

    @NotNull
    private String path;

    @Min(500)
    @Max(60000)
    @NotNull
    private Double size;

    public PictureImportDto() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
