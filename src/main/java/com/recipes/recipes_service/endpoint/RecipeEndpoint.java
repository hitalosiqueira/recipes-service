package com.recipes.recipes_service.endpoint;


import com.recipes.recipes_service.dto.Recipe;
import com.recipes.recipes_service.mapper.RecipeResourceMapper;
import com.recipes.recipes_service.resource.RecipeResource;
import com.recipes.recipes_service.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        value = "/api"
)
@AllArgsConstructor
public class RecipeEndpoint {
    RecipeService recipeService;
    RecipeResourceMapper recipeResourceMapper;

    @GetMapping(value = "/receitas")
    @ResponseBody
    public ResponseEntity<List<RecipeResource>> getAllRecipes(){
        List<Recipe> recipes = recipeService.getAllRecipes();
        List<RecipeResource> recipeResource = recipeResourceMapper.toRecipeResource(recipes);

        return new ResponseEntity<>(recipeResource, HttpStatus.OK);
    }
}
