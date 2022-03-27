package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.ImportDtoXML.PostImportDto;
import softuni.exam.instagraphlite.models.ImportDtoXML.PostRootImportDto;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.Post;
import softuni.exam.instagraphlite.models.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private static final String POST_FILE_PATH = "src/main/resources/files/posts.xml";

    private final PostRepository postRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ValidationUtil validationUtil, ModelMapper modelMapper, UserRepository userRepository, PictureRepository pictureRepository) {
        this.postRepository = postRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public boolean areImported() {
        return postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POST_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(PostRootImportDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        PostRootImportDto postRootImportDto =
                (PostRootImportDto) unmarshaller.unmarshal(new FileReader(POST_FILE_PATH));


        return postRootImportDto
                .getPosts()
                .stream()
                .map(this::importPost)
                .collect(Collectors.joining("\n"));
    }

    private String importPost(PostImportDto dto) {
        boolean isValid = validationUtil.isValid(dto);
        if (!isValid) {
            return "Invalid Post";
        }
        Optional<User> userByName = userRepository.findByUsername(dto.getUsername().getUsername());
        if (userByName.isEmpty()) {
            return "Invalid Post";
        }
        Optional<Picture> pictureByPath = pictureRepository.findByPath(dto.getPath().getPath());
        if (pictureByPath.isEmpty()) {
            return "Invalid Post";
        }

        Post post = modelMapper.map(dto, Post.class);
        post.setUser(userByName.get());
        post.setPicture(pictureByPath.get());
        postRepository.save(post);
        return "Successfully imported Post, made by " + dto.getUsername().getUsername();
    }
}
