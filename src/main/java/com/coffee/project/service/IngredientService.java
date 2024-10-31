package com.coffee.project.service;

import com.coffee.project.model.Ingredient;
import com.coffee.project.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public void updateIngredientQuantity(Long ingredientId,int quantity) {
        Ingredient ingredient = ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
        ingredient.setQuantity(quantity);
        ingredientRepository.save(ingredient);
    }
}

