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
        "nome",
        "porções",
        "calorias",
        "instruções"
})
public class RecipeResource extends ResourceSupport {

    @JsonProperty("nome")
    private String recipeName;

    @JsonProperty("porções")
    private Integer portions;

    @JsonProperty("calorias")
    private Integer calories;

    @JsonProperty("instruções")
    private String instructions;
}
