package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class ShampooServiceImpl implements ShampooService {

    @Autowired
    private ShampooRepository shampooRepository;


    @Override
    public List<Shampoo> findBySize(Size size) {
        return this.shampooRepository.findBySize(size);
    }

    @Override
    public List<Shampoo> findBySizeOrLabelIdOrderByPriceAsc(Size size, Long id) {
        return this.shampooRepository.findBySizeOrLabelIdOrderByPriceAsc(size, id);
    }

    @Override
    public List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price) {
        return this.shampooRepository.findByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public int countAllByPriceLessThan(BigDecimal price) {
        return shampooRepository.countAllByPriceLessThan(price);
    }

    @Override
    public List<Shampoo> findAllByIngredients(Set<String> ingredients) {
        return shampooRepository.findAllByIngredients(ingredients);
    }

    @Override
    public List<Shampoo> findAllByIngredientsLessThan(int number) {
        return shampooRepository.findAllByIngredientsLessThan(number);
    }
}
