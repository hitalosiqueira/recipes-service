package com.recipes.recipes_service.service;

import com.recipes.recipes_service.dto.Recipe;
import com.recipes.recipes_service.repository.RecipeIngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService {
    RecipeIngredientRepository recipeIngredientRepository;


    public List<Recipe> getAllRecipes() {
       return recipeIngredientRepository.getAllRecipes();
    }
}
