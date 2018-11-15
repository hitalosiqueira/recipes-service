package com.recipes.recipes_service.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class IngredientResource extends ResourceSupport {

    @JsonProperty("ingrediente")
    private String ingredientName;

}
