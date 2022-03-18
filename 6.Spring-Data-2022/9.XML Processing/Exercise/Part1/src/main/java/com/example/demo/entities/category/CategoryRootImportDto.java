package com.example.demo.entities.category;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryRootImportDto {

    @XmlElement(name = "category")
    List<CategoryImportDto> categoryRootImportDtoList;

    public List<CategoryImportDto> getCategoryRootImportDtoList() {
        return categoryRootImportDtoList;
    }

    public void setCategoryRootImportDtoList(List<CategoryImportDto> categoryRootImportDtoList) {
        this.categoryRootImportDtoList = categoryRootImportDtoList;
    }
}
