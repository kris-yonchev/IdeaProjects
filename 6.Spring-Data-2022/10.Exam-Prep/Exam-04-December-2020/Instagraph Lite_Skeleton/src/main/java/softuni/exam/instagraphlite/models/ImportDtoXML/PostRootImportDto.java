package softuni.exam.instagraphlite.models.ImportDtoXML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "posts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostRootImportDto {

    @XmlElement(name = "post")
    private List<PostImportDto> posts;

    public PostRootImportDto() {
    }

    public List<PostImportDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostImportDto> posts) {
        this.posts = posts;
    }
}
