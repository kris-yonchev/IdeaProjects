package com.example.demo.services;

import com.example.demo.entities.category.Category;
import com.example.demo.entities.category.CategoryByCountDto;
import com.example.demo.entities.category.CategoryRootImportDto;
import com.example.demo.entities.category.ProductsByCategoryDto;
import com.example.demo.entities.product.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final String CATEGORY_FILE_PATH = "src/main/resources/categories.xml";

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedData() throws IOException, JAXBException {
        if (categoryRepository.count() > 0) {
            return;
        }
        JAXBContext jaxbContext = JAXBContext.newInstance(CategoryRootImportDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        CategoryRootImportDto categoryRootImportDto = (CategoryRootImportDto) unmarshaller.unmarshal(new FileReader(CATEGORY_FILE_PATH));
        List<Category> categories = categoryRootImportDto.getCategoryRootImportDtoList()
                .stream()
                .filter(validationUtil::isValid)
                .map(c -> modelMapper.map(c, Category.class))
                .collect(Collectors.toList());

        categoryRepository.saveAll(categories);

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
    public CategoryByCountDto findCategoryByProductCount() {
        List<Category> categories = categoryRepository.getCategoriesByProductCount();
        CategoryByCountDto categoryByCountDto = new CategoryByCountDto();
        categoryByCountDto.setCategories(categories
                .stream()
                .filter(validationUtil::isValid)
                .map(c -> {
                    int count = c.getProducts().size();
                    ProductsByCategoryDto productsByCategoryDto = modelMapper.map(c, ProductsByCategoryDto.class);
                    productsByCategoryDto.setProductsCount(count);
                    BigDecimal total = c.getProducts().stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
                    productsByCategoryDto.setTotalRevenue(total);
                    if (count > 0) {
                        BigDecimal average = total.divide(BigDecimal.valueOf(count), RoundingMode.FLOOR);
                        productsByCategoryDto.setAveragePrice(average);
                    }
                    return productsByCategoryDto;
                }).collect(Collectors.toList()));

        return categoryByCountDto;
    }

}
