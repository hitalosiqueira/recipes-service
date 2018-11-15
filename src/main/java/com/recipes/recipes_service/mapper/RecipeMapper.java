package com.recipes.recipes_service.mapper;

import com.recipes.recipes_service.dto.Ingredient;
import com.recipes.recipes_service.dto.Recipe;
import com.recipes.recipes_service.entity.IngredientEntity;
import com.recipes.recipes_service.entity.RecipeEntity;
import com.recipes.recipes_service.entity.RecipeIngredientEntity;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface RecipeMapper {

    List<Recipe> fromRecipesEntityToRecipesDto(List<RecipeEntity> recipeEntities);

    Ingredient toIngredientDto(IngredientEntity ingredientEntity);

    default List<Ingredient> fromRecipeIngredientEntityToIngredientsDto(List<RecipeIngredientEntity> recipeIngredientEntities) {
        List<Ingredient> ingredients = new ArrayList<>();
        recipeIngredientEntities.forEach(e -> {

            Ingredient ingredient = toIngredientDto(e
                    .getPrimaryKey()
                    .getIngredientEntity());

            ingredient.setAmount(e.getAmount());
            ingredients.add(ingredient);
        });

        return ingredients;
    }

    default List<Recipe> fromRecipeIngredientEntityToRecipesDto(List<RecipeIngredientEntity> recipeIngredientEntities) {
        List<Recipe> recipes = new ArrayList<>();
        recipeIngredientEntities.forEach(e -> {

            Recipe recipe = toRecipeDto(e
                    .getPrimaryKey()
                    .getRecipeEntity());

            recipes.add(recipe);
        });

        return recipes;
    }

    Recipe toRecipeDto(RecipeEntity recipeEntity);

    List<Ingredient> fromIngredientsEntityToIngredientsDto(List<IngredientEntity> recipeEntities);

    RecipeEntity toRecipeEntity(Recipe recipe);
}
