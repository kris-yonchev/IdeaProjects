package com.example.demo.services;

import com.example.demo.entities.Category;
import com.example.demo.entities.dto.CategoriesInfoDto;
import com.example.demo.entities.dto.CategoryInputDto;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final String CATEGORY_FILE_PATH = "src/main/resources/categories.json";

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedData() throws IOException {
        if (categoryRepository.count() > 0) {
            return;
        }

        Arrays.stream(
                gson.fromJson
                        (Files.readString(Path.of(CATEGORY_FILE_PATH)), CategoryInputDto[].class))
                .filter(validationUtil::isValid)
                .map(categoryInputDto -> modelMapper.map(categoryInputDto, Category.class))
                .forEach(categoryRepository::save);

    }

    @Override
    public List<Category> findRandomCategories() {
        int catCount = ThreadLocalRandom.current().nextInt(1, 4);

        List<Category> categories = new ArrayList<>();

        for (int i = 0; i < catCount; i++) {
            categories
                    .add(categoryRepository
                            .findById(ThreadLocalRandom.current()
                                    .nextInt(1, (int) categoryRepository.count() + 1))
                            .orElse(null));
        }
        return categories;
    }

    @Override
    public List<CategoriesInfoDto> findAvgInfoForCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoriesInfoDto> categoriesInfoDtos = new ArrayList<>();
        for (Category category : categories) {
            CategoriesInfoDto categoriesInfoDto = new CategoriesInfoDto();
            categoriesInfoDto.setCategory(category.getName());
            categoriesInfoDto.setAvgPrice(category.getProducts().stream().mapToDouble(p -> p.getPrice().doubleValue()).average().getAsDouble());
            categoriesInfoDto.setTotalRevenue(category.getProducts().stream().mapToDouble(p -> p.getPrice().doubleValue()).sum());

            categoriesInfoDto.setProductsCount(category.getProducts().size());

            categoriesInfoDtos.add(categoriesInfoDto);
        }

        categoriesInfoDtos.sort((c1, c2) -> Integer.compare(c2.getProductsCount(), c1.getProductsCount()));
        return categoriesInfoDtos;
    }
}
