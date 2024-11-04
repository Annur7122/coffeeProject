package com.coffee.project.service;

import com.coffee.project.model.Ingredient;
import com.coffee.project.model.Recipe;
import com.coffee.project.repository.DrinkRepository;
import com.coffee.project.repository.RecipeRepository;
import com.coffee.project.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coffee.project.model.Drink;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private StatisticsRepository statisticsRepository;

    public Recipe createRecipe(Drink drink, Ingredient ingredient, int amount){
        Recipe recipe = new Recipe(drink,ingredient,amount);
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getRecipesForDrink(Long drinkId) {
        Drink drink = drinkRepository.findById(drinkId)
                .orElseThrow(() -> new RuntimeException("Drink not found"));
        return recipeRepository.findByDrink(drink);
    }
}
