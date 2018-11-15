package com.recipes.recipes_service.resource;

import com.recipes.recipes_service.dto.Ingredient;
import com.recipes.recipes_service.endpoint.RecipeEndpoint;
import com.recipes.recipes_service.mapper.RecipeResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class IngredientRecipeResourceAssembler extends ResourceAssemblerSupport<Ingredient, IngredientRecipeResource> {

    @Autowired
    RecipeResourceMapper recipeResourceMapper;

    public IngredientRecipeResourceAssembler() {
        super(RecipeEndpoint.class, IngredientRecipeResource.class);
    }


    @Override
    public IngredientRecipeResource toResource(Ingredient ingredient) {
        return recipeResourceMapper.toIngredientRecipeResource(ingredient);
    }
}
