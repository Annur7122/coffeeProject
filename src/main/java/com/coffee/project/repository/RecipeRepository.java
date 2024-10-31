package com.coffee.project.repository;

import com.coffee.project.model.Drink;
import com.coffee.project.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByDrink(Drink drink);
}
