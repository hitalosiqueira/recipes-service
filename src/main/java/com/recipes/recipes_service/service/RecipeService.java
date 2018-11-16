package com.recipes.recipes_service.service;

import com.recipes.recipes_service.dto.Ingredient;
import com.recipes.recipes_service.dto.Recipe;
import com.recipes.recipes_service.infra.error.ErrorCode;
import com.recipes.recipes_service.infra.exception.BadRequestException;
import com.recipes.recipes_service.infra.exception.NotFoundException;
import com.recipes.recipes_service.repository.RecipeIngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService {
    private static final String PATTERN_NAME = "[a-zA-Z ]+";
    private RecipeIngredientRepository recipeIngredientRepository;


    public List<Recipe> getAllRecipes() {
        return recipeIngredientRepository.getAllRecipes();
    }

    public Recipe getRecipeById(Long id) {
        Recipe recipe;

        try{
            recipe = recipeIngredientRepository.getRecipeById(id);
        }catch (EntityNotFoundException ex){
            throw new NotFoundException(ErrorCode.NOT_FOUND_RECIPE);
        }

        return recipe;
    }

    public List<Ingredient> getRecipeIngredients(Long id) {
        List<Ingredient> ingredients;

        try{
            ingredients = recipeIngredientRepository.getRecipeIngredient(id);
        }catch (EntityNotFoundException ex){
            throw new NotFoundException(ErrorCode.NOT_FOUND_INGREDIENT);
        }

        return ingredients;
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
        Ingredient ingredient;

        try{
            ingredient = recipeIngredientRepository.getIngredientById(id);
        }catch (EntityNotFoundException ex){
            throw new NotFoundException(ErrorCode.NOT_FOUND_INGREDIENT);
        }

        return ingredient;
    }

    public Recipe createRecipe(Recipe recipe) {
        validateRecipe(recipe);
        return recipeIngredientRepository.createRecipe(recipe);
    }

    private void validateRecipe(Recipe recipe) {

        if(recipe.getRecipeName() == null){
            throw new BadRequestException(ErrorCode.BAD_REQUEST_NAME_REQUIRED);
        }

        if(!recipe.getRecipeName().matches(PATTERN_NAME)){
            throw new BadRequestException(ErrorCode.BAD_REQUEST_NAME_INVALID);
        }

        if(recipe.getPortions() == null){
            throw new BadRequestException(ErrorCode.BAD_REQUEST_PORTIONS_REQUIRED);
        }

        if(recipe.getPortions() < 1){
            throw new BadRequestException(ErrorCode.BAD_REQUEST_PORTIONS_INVALID);
        }

        if(recipe.getCalories() == null){
            throw new BadRequestException(ErrorCode.BAD_REQUEST_CALORIES_REQUIRED);
        }

        if(recipe.getCalories() < 0){
            throw new BadRequestException(ErrorCode.BAD_REQUEST_CALORIES_INVALID);
        }

        if(recipe.getInstructions() == null){
            throw new BadRequestException(ErrorCode.BAD_REQUEST_INSTRUCTIONS_REQUIRED);
        }

        if(recipe.getIngredients().size() < 1){
            throw new BadRequestException(ErrorCode.BAD_REQUEST_INGREDIENTS_REQUIRED);
        }

        recipe.getIngredients().forEach(e -> {
            if(e.getIngredientName() == null){
                throw new BadRequestException(ErrorCode.BAD_REQUEST_INGREDIENT_NAME_REQUIRED);
            }

            if(e.getAmount() == null){
                throw new BadRequestException(ErrorCode.BAD_REQUEST_INGREDIENT_AMOUNT_REQUIRED);
            }
        });
    }
}