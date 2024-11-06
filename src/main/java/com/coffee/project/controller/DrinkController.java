package com.coffee.project.controller;

import com.coffee.project.model.Drink;
import com.coffee.project.model.Ingredient;
import com.coffee.project.service.DrinkService;
import com.coffee.project.service.IngredientService;
import com.coffee.project.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drinks")
public class DrinkController {

    @Autowired
    private DrinkService drinkService;
    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/")
    public List<Drink> getAllDrinks() {
        return drinkService.getAllDrinks();
    }

    @PostMapping("/{drinkId}/prepare")
    public ResponseEntity<String> prepareDrink(@PathVariable Long drinkId) {
        drinkService.prepareDrink(drinkId);
        return new ResponseEntity<>("Drink prepared successfully", HttpStatus.OK);
    }

    @GetMapping("/most-popular")
    public ResponseEntity<Drink> getMostPopularDrink() {
        Drink mostPopularDrink = drinkService.getMostPopularDrink();
        return new ResponseEntity<>(mostPopularDrink, HttpStatus.OK);
    }

    @PostMapping("/{drinkId}/recipes")
    public ResponseEntity<String> addRecipe(@PathVariable Long drinkId,
                                            @RequestParam Long ingredientId,
                                            @RequestParam int amount) {
        Drink drink = drinkService.getDrink(drinkId);
        Ingredient ingredient = ingredientService.getIngredient(ingredientId);

        recipeService.addRecipe(drink, ingredient, amount);
        return new ResponseEntity<>("Recipe added successfully", HttpStatus.OK);
    }
}
