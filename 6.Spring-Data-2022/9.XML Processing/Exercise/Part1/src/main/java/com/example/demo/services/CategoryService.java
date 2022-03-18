package com.example.demo.services;

import com.example.demo.entities.category.Category;
import com.example.demo.entities.category.CategoryByCountDto;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface CategoryService {

    void seedData() throws IOException, JAXBException;

    List<Category> findRandomCategories();

    CategoryByCountDto findCategoryByProductCount();
}
