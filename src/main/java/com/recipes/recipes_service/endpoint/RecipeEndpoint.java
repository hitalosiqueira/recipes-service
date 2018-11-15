package com.recipes.recipes_service.endpoint;


import com.recipes.recipes_service.dto.Ingredient;
import com.recipes.recipes_service.dto.Recipe;
import com.recipes.recipes_service.mapper.RecipeResourceMapper;
import com.recipes.recipes_service.resource.*;
import com.recipes.recipes_service.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(
        value = "/api",
        produces = MediaTypes.HAL_JSON_VALUE
)
@AllArgsConstructor
public class RecipeEndpoint {

    RecipeService recipeService;
    RecipeResourceMapper recipeResourceMapper;
    RecipeResourceAssembler recipeResourceAssembler;
    IngredientRecipeResourceAssembler ingredientRecipeResourceAssembler;
    IngredientResourceAssembler ingredientResourceAssembler;


    @GetMapping(value = "/receitas")
    public ResponseEntity<Resources<RecipeResource>> getAllRecipes(){
        List<Recipe> recipes = recipeService.getAllRecipes();
        List<RecipeResource> recipeResources = recipeResourceAssembler.toResources(recipes);

        Link link = linkTo(methodOn(RecipeEndpoint.class).getAllRecipes()).withSelfRel();
        Resources<RecipeResource> result = new Resources<>(recipeResources, link);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/receitas/{id:[0-9]+}")
    public ResponseEntity<RecipeResource> getRecipeById(@PathVariable("id") Long id){
        Recipe recipe = recipeService.getRecipeById(id);
        RecipeResource recipeResource = recipeResourceAssembler.toResource(recipe);

        return ResponseEntity.ok(recipeResource);
    }

    @GetMapping(value = "/receitas/{id:[0-9]+}/ingredientes")
    public ResponseEntity<Resources<IngredientRecipeResource>> getRecipeIngredients(@PathVariable("id") Long id){
        List<Ingredient> ingredients = recipeService.getRecipeIngredients(id);
        List<IngredientRecipeResource> ingredientRecipeResource = ingredientRecipeResourceAssembler.toResources(ingredients);

        Link link = linkTo(methodOn(RecipeEndpoint.class).getRecipeIngredients(id)).withSelfRel();
        Resources<IngredientRecipeResource> result = new Resources<>(ingredientRecipeResource, link);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/receitas/-/ingredientes/{id:[0-9]+}")
    public ResponseEntity<Resources<RecipeResource>> getRecipeFromIngredient(@PathVariable("id") Long id){
        List<Recipe> recipes = recipeService.getRecipesFromIngredient(id);
        List<RecipeResource> recipeResources = recipeResourceAssembler.toResources(recipes);

        Link link = linkTo(methodOn(RecipeEndpoint.class).getRecipeFromIngredient(id)).withSelfRel();
        Resources<RecipeResource> result = new Resources<>(recipeResources, link);

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @GetMapping(value = "/receitas/{ingrediente:[a-zA-Z]+}")
    public ResponseEntity<Resources<RecipeResource>> getRecipeFromIngredientName(@PathVariable("ingrediente") String ingredient){
        List<Recipe> recipes = recipeService.getRecipesFromIngredientName(ingredient);
        List<RecipeResource> recipeResources = recipeResourceAssembler.toResources(recipes);

        Link link = linkTo(methodOn(RecipeEndpoint.class).getRecipeFromIngredientName(ingredient)).withSelfRel();
        Resources<RecipeResource> result = new Resources<>(recipeResources, link);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/ingredientes")
    public ResponseEntity<Resources<IngredientResource>> getAllIngredients(){
        List<Ingredient> ingredients = recipeService.getAllIngredients();
        List<IngredientResource> ingredientResources = ingredientResourceAssembler.toResources(ingredients);

        Link link = linkTo(methodOn(RecipeEndpoint.class).getAllIngredients()).withSelfRel();
        Resources<IngredientResource> result = new Resources<>(ingredientResources, link);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/ingredientes/{id}")
    public ResponseEntity<IngredientResource> getIngredientById(@PathVariable("id") Long id){
        Ingredient ingredient = recipeService.getIngredientById(id);
        IngredientResource ingredientResource = ingredientResourceAssembler.toResource(ingredient);

        return ResponseEntity.ok(ingredientResource);
    }
}
