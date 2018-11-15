package com.recipes.recipes_service.resource;

import com.recipes.recipes_service.dto.Ingredient;
import com.recipes.recipes_service.endpoint.RecipeEndpoint;
import com.recipes.recipes_service.mapper.RecipeResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class IngredientResourceAssembler extends ResourceAssemblerSupport<Ingredient, IngredientResource> {

    @Autowired
    RecipeResourceMapper recipeResourceMapper;

    public IngredientResourceAssembler() {
        super(RecipeEndpoint.class, IngredientResource.class);
    }


    @Override
    public IngredientResource toResource(Ingredient ingredient) {
        return recipeResourceMapper.toIngredientResource(ingredient);
    }
}
