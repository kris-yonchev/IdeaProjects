package com.example.demo.entities.category;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryByCountDto {

    @XmlElement(name = "category")
    private List<ProductsByCategoryDto> categories;

    public CategoryByCountDto() {
    }

    public List<ProductsByCategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<ProductsByCategoryDto> categories) {
        this.categories = categories;
    }
}
