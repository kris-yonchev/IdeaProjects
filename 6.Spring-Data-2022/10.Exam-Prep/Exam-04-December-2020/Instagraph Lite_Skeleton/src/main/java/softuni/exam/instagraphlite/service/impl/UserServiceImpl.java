package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.User;
import softuni.exam.instagraphlite.models.importDtoJSON.UserImportDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private static final String USER_FILE_PATH = "src/main/resources/files/users.json";

    private final UserRepository userRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final PictureRepository pictureRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, PictureRepository pictureRepository) {
        this.userRepository = userRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.pictureRepository = pictureRepository;
    }


    @Override
    public boolean areImported() {
        return userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USER_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        UserImportDto[] userImportDtos = gson.fromJson(readFromFileContent(), UserImportDto[].class);

        return Arrays.stream(userImportDtos)
                .map(this::importUser)
                .collect(Collectors.joining("\n"));
    }

    private String importUser(UserImportDto dto) {
        boolean isValid = validationUtil.isValid(dto);
        if (!isValid) {
            return "Invalid User";
        }
        Optional<User> userWithName = userRepository.findByUsername(dto.getUsername());
        if (userWithName.isPresent()) {
            return "Invalid User";
        }
        Optional<Picture> picture = pictureRepository.findByPath(dto.getProfilePicture());
        if (picture.isEmpty()) {
            return "Invalid User";
        }
        User user = modelMapper.map(dto, User.class);
        user.setProfilePicture(picture.get());
        userRepository.save(user);
        return "Successfully imported User: " + user.getUsername();
    }

    @Override
    public String exportUsersWithTheirPosts() {
        StringBuilder sb = new StringBuilder();
        List<User> users = userRepository.findAllByPostCount();


        users.forEach(e -> {
            sb.append("User: ").append(e.getUsername()).append(System.lineSeparator());
            sb.append("Post Count: ").append(e.getPosts().size()).append(System.lineSeparator());
            sb.append("==Post Details:\n");
            e.getPosts().stream()
                    .sorted(Comparator.comparingDouble(p -> p.getPicture().getSize()))
                    .forEach(p -> {
                sb.append("----Caption: ").append(p.getCaption()).append(System.lineSeparator());
                sb.append("----Picture Size: ").append(String.format("%.2f", p.getPicture().getSize())).append(System.lineSeparator());
            });
        });

        return sb.toString().trim();
    }
}
