package com.recipes.recipes_service.repository;

import com.recipes.recipes_service.dto.Ingredient;
import com.recipes.recipes_service.dto.Recipe;
import com.recipes.recipes_service.entity.IngredientEntity;
import com.recipes.recipes_service.entity.RecipeEntity;
import com.recipes.recipes_service.mapper.RecipeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class RecipeIngredientRepository {
    IngredientJpaRepository ingredientJpaRepository;
    RecipeJpaRepository recipeJpaRepository;
    RecipeMapper recipeMapper;


    public List<Recipe> getAllRecipes() {
        List<RecipeEntity> recipeEntities = recipeJpaRepository.findAll();
        return recipeMapper.fromRecipesEntityToRecipesDto(recipeEntities);
    }

    public Recipe getRecipeById(Long id) {
        RecipeEntity recipeEntity = recipeJpaRepository.getOne(id);

        return recipeMapper.toRecipeDto(recipeEntity);
    }

    public List<Ingredient> getRecipeIngredient(Long id) {
        RecipeEntity recipeEntity = recipeJpaRepository.getOne(id);

        return recipeMapper.fromRecipeIngredientEntityToIngredientsDto(recipeEntity.getIngredients());
    }

    public List<Recipe> getRecipeFromIngredient(Long id) {
        IngredientEntity ingredientEntity = ingredientJpaRepository.getOne(id);

        return recipeMapper.fromRecipeIngredientEntityToRecipesDto(ingredientEntity.getRecipes());
    }

    public List<Recipe> getRecipeFromIngredientName(String ingredient) {
        IngredientEntity ingredientEntity = ingredientJpaRepository.findByIngredientName(ingredient);

        return recipeMapper.fromRecipeIngredientEntityToRecipesDto(ingredientEntity.getRecipes());
    }

    public List<Ingredient> getAllIngredients() {
        List<IngredientEntity> ingredientEntities = ingredientJpaRepository.findAllByOrderByIngredientNameAsc();
        return recipeMapper.fromIngredientsEntityToIngredientsDto(ingredientEntities);
    }

    public Ingredient getIngredientById(Long id) {
        IngredientEntity ingredientEntity = ingredientJpaRepository.getOne(id);

        return recipeMapper.toIngredientDto(ingredientEntity);
    }
}
