package com.example.book_shop.services;

import com.example.book_shop.models.Category;

import java.util.Set;

public interface CategoryService {
    Set<Category> getRandomCategories();
}
