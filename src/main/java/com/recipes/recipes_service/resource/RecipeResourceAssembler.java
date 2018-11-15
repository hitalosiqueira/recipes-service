package com.recipes.recipes_service.resource;

import com.recipes.recipes_service.dto.Recipe;
import com.recipes.recipes_service.endpoint.RecipeEndpoint;
import com.recipes.recipes_service.mapper.RecipeResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class RecipeResourceAssembler extends ResourceAssemblerSupport<Recipe, RecipeResource> {

    @Autowired
    RecipeResourceMapper recipeResourceMapper;

    public RecipeResourceAssembler() {
        super(RecipeEndpoint.class, RecipeResource.class);
    }

    @Override
    public RecipeResource toResource(Recipe recipe) {
        RecipeResource recipeResource = recipeResourceMapper.toRecipeResource(recipe);

        recipeResource
                .add(linkTo(methodOn(RecipeEndpoint.class)
                        .getRecipeIngredients(recipe
                                .getRecipe_id()))
                        .withRel("recipeIngredients"));
        recipeResource
                .add(linkTo(methodOn(RecipeEndpoint.class)
                        .getRecipeById(recipe
                                .getRecipe_id()))
                        .withSelfRel());

        return recipeResource;
    }
}
