package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;


    @Override
    public List<Ingredient> findByNameStartingWith(String letter) {
        return this.ingredientRepository.findByNameStartingWith(letter);
    }

    @Override
    public List<Ingredient> findAllByNameInOrderByPrice(List<String> names) {
        return ingredientRepository.findByNameInOrderByPrice(names);
    }

    @Override
    @Transactional
    public int deleteIngredientsByName(String name) {
        return ingredientRepository.deleteIngredientByName(name);
    }

    @Override
    @Transactional
    public int updateIngredientPriceBy10Percent() {
      return this.ingredientRepository.updateIngredientPriceBy10Percent();
    }

    @Override
    @Transactional
    public int updateIngredientPriceBy10PercentWithName(Set<String> ingredientsToUpdate) {
        return this.ingredientRepository.updateIngredientPriceBy10PercentWithName(ingredientsToUpdate);
    }
}
