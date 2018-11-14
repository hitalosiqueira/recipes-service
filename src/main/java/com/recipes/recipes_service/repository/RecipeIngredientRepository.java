package com.recipes.recipes_service.repository;

import com.recipes.recipes_service.dto.Recipe;
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
        return recipeMapper.toRecipesDto(recipeEntities);
    }
}
