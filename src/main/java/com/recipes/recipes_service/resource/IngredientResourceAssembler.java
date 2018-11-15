package com.recipes.recipes_service.resource;

import com.recipes.recipes_service.dto.Ingredient;
import com.recipes.recipes_service.endpoint.RecipeEndpoint;
import com.recipes.recipes_service.mapper.RecipeResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class IngredientResourceAssembler extends ResourceAssemblerSupport<Ingredient, IngredientResource> {

    @Autowired
    RecipeResourceMapper recipeResourceMapper;

    public IngredientResourceAssembler() {
        super(RecipeEndpoint.class, IngredientResource.class);
    }


    @Override
    public IngredientResource toResource(Ingredient ingredient) {

        IngredientResource ingredientResource = recipeResourceMapper.toIngredientResource(ingredient);

        ingredientResource
                .add(linkTo(methodOn(RecipeEndpoint.class)
                        .getIngredientById(ingredient
                                .getId()))
                        .withSelfRel());

        return ingredientResource;
    }
}
