package com.recipes.recipes_service.mapper;

import com.recipes.recipes_service.dto.Ingredient;
import com.recipes.recipes_service.dto.Recipe;
import com.recipes.recipes_service.resource.IngredientResource;
import com.recipes.recipes_service.resource.RecipeResource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecipeResourceMapper {

    List<RecipeResource> toRecipeResource(List <Recipe> recipe);

    IngredientResource toIngredientResource(Ingredient ingredient);

}
