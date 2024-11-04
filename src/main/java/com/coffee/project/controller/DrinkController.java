package com.coffee.project.controller;

import com.coffee.project.model.Drink;
import com.coffee.project.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drinks")
public class DrinkController {

    @Autowired
    private DrinkService drinkService;

    @GetMapping
    public List<Drink> getAllDrinks() {
        return drinkService.getAllDrinks();
    }

    @PostMapping("/{drinkId}/prepare")
    public String prepareDrink(@PathVariable Long drinkId) {
        drinkService.prepareDrink(drinkId);
        return "Drink prepared successfully";
    }
}
