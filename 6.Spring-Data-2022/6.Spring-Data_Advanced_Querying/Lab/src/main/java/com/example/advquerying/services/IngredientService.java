package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;

import java.util.List;
import java.util.Set;

public interface IngredientService {

    List<Ingredient> findByNameStartingWith(String letter);

    List<Ingredient> findAllByNameInOrderByPrice(List<String> names);

    int deleteIngredientsByName(String name);

    int updateIngredientPriceBy10Percent();

    int updateIngredientPriceBy10PercentWithName(Set<String> ingredientsToUpdate);
}

