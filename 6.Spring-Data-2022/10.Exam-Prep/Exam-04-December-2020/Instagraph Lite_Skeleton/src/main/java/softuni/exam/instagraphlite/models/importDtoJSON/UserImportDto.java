package softuni.exam.instagraphlite.models.importDtoJSON;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserImportDto {

    @Size(min = 2, max = 18)
    @NotNull
    private String username;

    @Size(min = 4)
    @NotNull
    private String password;

    @NotNull
    private String profilePicture;

    public UserImportDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
