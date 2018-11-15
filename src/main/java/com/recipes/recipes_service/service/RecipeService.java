package com.recipes.recipes_service.service;

import com.recipes.recipes_service.dto.Ingredient;
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

    public Recipe getRecipeById(Long id) {
        return recipeIngredientRepository.getRecipeById(id);
    }

    public List<Ingredient> getRecipeIngredients(Long id) {
        return recipeIngredientRepository.getRecipeIngredient(id);
    }

    public List<Recipe> getRecipesFromIngredient(Long id) {
        return recipeIngredientRepository.getRecipeFromIngredient(id);
    }

    public List<Recipe> getRecipesFromIngredientName(String ingredient) {
        return recipeIngredientRepository.getRecipeFromIngredientName(ingredient);
    }

    public List<Ingredient> getAllIngredients() {
        return recipeIngredientRepository.getAllIngredients();
    }

    public Ingredient getIngredientById(Long id) {
        return recipeIngredientRepository.getIngredientById(id);
    }
}
