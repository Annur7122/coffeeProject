package com.coffee.project.service;

import com.coffee.project.model.Drink;
import com.coffee.project.model.Ingredient;
import com.coffee.project.model.Recipe;
import com.coffee.project.model.Statistics;
import com.coffee.project.repository.DrinkRepository;
import com.coffee.project.repository.IngredientRepository;
import com.coffee.project.repository.RecipeRepository;
import com.coffee.project.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class DrinkService {

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private StatisticsRepository statisticsRepository;
    @Autowired
    private StatisticsService statisticsService;
    @Autowired
    private HolidayService holidayService;

    public void prepareDrink(Long drinkId){
        List<Recipe> recipes = recipeService.getRecipesForDrink(drinkId);

        if(isWithinOperatingHours() && !holidayService.isHoliday(LocalDate.now())) {
            for (Recipe recipe : recipes) {
                Ingredient ingredient = recipe.getIngredient();

                if (ingredientService.checkIngredientQuantity(ingredient.getId(), recipe.getAmount())) {
                    throw new RuntimeException("Ingredient not available");
                } else {
                    int actual_quantity = ingredient.getQuantity() - recipe.getAmount();
                    ingredientService.updateIngredientQuantity(ingredient.getId(), actual_quantity);
                }
            }
            statisticsService.implementDrinkStatistics(drinkId);
        }else throw new RuntimeException("Drink not available in that time period");

    }



    public boolean isWithinOperatingHours() {
        LocalTime now = LocalTime.now();
        DayOfWeek day = LocalDate.now().getDayOfWeek();

        return now.isAfter(LocalTime.of(8, 0)) && now.isBefore(LocalTime.of(17,0))
        && day != DayOfWeek.SATURDAY && day != DayOfWeek.SUNDAY;

        }

    public Drink getMostPopularDrink(){
        return statisticsRepository.findMax().get().getDrink();
    }

    public Drink getDrink(Long drinkId){
        return drinkRepository.findById(drinkId)
                .orElseThrow(() -> new RuntimeException("Drink no found"));
    }


    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

}
