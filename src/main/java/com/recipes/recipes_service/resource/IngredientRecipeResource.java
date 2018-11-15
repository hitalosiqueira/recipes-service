package com.recipes.recipes_service.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class IngredientRecipeResource extends ResourceSupport {

    @JsonProperty("ingrediente")
    private String ingredientName;

    @JsonProperty("quantidade")
    private String amount;
}
