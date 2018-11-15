package com.recipes.recipes_service.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@JsonPropertyOrder({
        "quantidade"
})
public class IngredientRecipeResource extends ResourceSupport {

    @JsonProperty("quantidade")
    private String amount;
}
