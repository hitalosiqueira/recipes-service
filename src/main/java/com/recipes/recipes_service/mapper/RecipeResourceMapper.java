package com.recipes.recipes_service.mapper;

import com.recipes.recipes_service.dto.Ingredient;
import com.recipes.recipes_service.dto.Recipe;
import com.recipes.recipes_service.resource.IngredientRecipeResource;
import com.recipes.recipes_service.resource.IngredientResource;
import com.recipes.recipes_service.resource.RecipeResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipeResourceMapper {

    RecipeResource toRecipeResource(Recipe recipe);

    IngredientRecipeResource toIngredientRecipeResource(Ingredient ingredient);

    IngredientResource toIngredientResource(Ingredient ingredient);


}
