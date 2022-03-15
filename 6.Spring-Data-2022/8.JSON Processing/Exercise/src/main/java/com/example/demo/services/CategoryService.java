package com.example.demo.services;

import com.example.demo.entities.Category;
import com.example.demo.entities.dto.CategoriesInfoDto;

import java.io.IOException;
import java.util.List;

public interface CategoryService {

    void seedData() throws IOException;

    List<Category> findRandomCategories();

    List<CategoriesInfoDto> findAvgInfoForCategories();
}
