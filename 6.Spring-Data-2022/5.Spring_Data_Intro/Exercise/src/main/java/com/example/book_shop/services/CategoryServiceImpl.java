package com.example.book_shop.services;

import com.example.book_shop.models.Category;
import com.example.book_shop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    Random random = new Random();

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public Set<Category> getRandomCategories() {
        long count = this.categoryRepository.count();

        int categoriesCount = random.nextInt((int) count) + 1;
        Set<Category> categories = new HashSet<>();


        for (int i = 0; i < categoriesCount; i++) {
            int nextId = random.nextInt((int) count) + 1;
            Category category = categoryRepository.getById(nextId);
            categories.add(category);
        }


        return categories;

    }
}
