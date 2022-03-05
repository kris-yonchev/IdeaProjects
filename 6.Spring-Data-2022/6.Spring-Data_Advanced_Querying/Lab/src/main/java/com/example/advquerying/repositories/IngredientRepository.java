package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findByNameStartingWith(String letter);

    List<Ingredient> findByNameInOrderByPrice(List<String> names);

    @Modifying
    int deleteIngredientByName(String name);

    @Modifying
    @Query("UPDATE Ingredient i" +
            " SET i.price = i.price * 1.1")
    int updateIngredientPriceBy10Percent();

    @Modifying
    @Query("UPDATE Ingredient i" +
            " SET i.price = i.price * 1.1" +
            " WHERE i.name IN :ingredientsToUpdate")
    int updateIngredientPriceBy10PercentWithName(Set<String> ingredientsToUpdate);
}

