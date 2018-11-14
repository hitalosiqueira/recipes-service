package com.recipes.recipes_service.endpoint;


import com.recipes.recipes_service.dto.Recipe;
import com.recipes.recipes_service.service.RecipeService;
import lombok.AllArgsConstructor;
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

    @GetMapping(value = "/receitas")
    @ResponseBody
    public List<Recipe> getAllRecipes(){
        return recipeService.getAllRecipes();
    }
}
