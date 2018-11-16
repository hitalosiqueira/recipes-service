package com.recipes.recipes_service.repository;

import com.recipes.recipes_service.dto.Ingredient;
import com.recipes.recipes_service.dto.Recipe;
import com.recipes.recipes_service.entity.IngredientEntity;
import com.recipes.recipes_service.entity.RecipeEntity;
import com.recipes.recipes_service.entity.RecipeIngredientEntity;
import com.recipes.recipes_service.entity.RecipeIngredientIdEntity;
import com.recipes.recipes_service.infra.error.ErrorCode;
import com.recipes.recipes_service.infra.exception.NotFoundException;
import com.recipes.recipes_service.mapper.RecipeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class RecipeIngredientRepository {
    IngredientJpaRepository ingredientJpaRepository;
    RecipeJpaRepository recipeJpaRepository;
    RecipeIngredientJpaRepository recipeIngredientJpaRepository;
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

        if(ingredientEntity == null){
            return new ArrayList<>();
        }else{
            return recipeMapper.fromRecipeIngredientEntityToRecipesDto(ingredientEntity.getRecipes());
        }
    }

    public List<Ingredient> getAllIngredients() {
        List<IngredientEntity> ingredientEntities = ingredientJpaRepository.findAllByOrderByIngredientNameAsc();
        return recipeMapper.fromIngredientsEntityToIngredientsDto(ingredientEntities);
    }

    public Ingredient getIngredientById(Long id) {
        IngredientEntity ingredientEntity = ingredientJpaRepository.getOne(id);

        return recipeMapper.toIngredientDto(ingredientEntity);
    }

    public Recipe createRecipe(Recipe recipe) {
        final RecipeEntity recipeEntity = recipeMapper.toRecipeEntity(recipe);
        List<RecipeIngredientEntity> recipeIngredientEntities = new ArrayList<>();

        recipe.getIngredients().forEach(e -> {
            RecipeIngredientEntity recipeIngredientEntity = new RecipeIngredientEntity();
            RecipeIngredientIdEntity recipeIngredientIdEntity = new RecipeIngredientIdEntity();
            IngredientEntity ingredientEntity = ingredientJpaRepository.findByIngredientName(e.getIngredientName());

            if(ingredientEntity == null){
                throw new NotFoundException(ErrorCode.NOT_FOUND_INGREDIENT);
            }

            recipeIngredientIdEntity.setRecipeEntity(recipeEntity);
            recipeIngredientIdEntity.setIngredientEntity(ingredientEntity);

            recipeIngredientEntity.setAmount(e.getAmount());
            recipeIngredientEntity.setPrimaryKey(recipeIngredientIdEntity);
            recipeIngredientEntities.add(recipeIngredientEntity);
        });
        recipeEntity.setIngredients(recipeIngredientEntities);

        recipeJpaRepository.save(recipeEntity);

        return recipeMapper.toRecipeDto(recipeEntity);


    }
}
