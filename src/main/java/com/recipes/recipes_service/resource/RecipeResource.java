package com.recipes.recipes_service.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RecipeResource {

    @JsonProperty("nome")
    private String recipeName;

    @JsonProperty("porções")
    private Integer portions;

    @JsonProperty("calorias")
    private Integer calories;

    @JsonProperty("instruções")
    private String instructions;

    @JsonProperty("ingredientes")
    private List<IngredientResource> ingredients;
}
