package com.recipes.recipes_service.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IngredientResource {

    @JsonProperty("ingrediente")
    private String ingredientName;

    @JsonProperty("quantidade")
    private String amount;
}
