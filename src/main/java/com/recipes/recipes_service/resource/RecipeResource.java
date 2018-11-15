package com.recipes.recipes_service.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class RecipeResource extends ResourceSupport {

    @JsonProperty("nome")
    private String recipeName;

    @JsonProperty("porções")
    private Integer portions;

    @JsonProperty("calorias")
    private Integer calories;

    @JsonProperty("instruções")
    private String instructions;

    @JsonProperty("ingredientes")
    private List<IngredientRecipeResource> ingredients;
}
