package com.recipes.recipes_service.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import java.util.List;
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@JsonPropertyOrder({
        "name",
        "portions",
        "calories",
        "instructions"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(value="recipe", collectionRelation="recipes")
public class RecipeResource extends ResourceSupport {

    @JsonProperty("name")
    private String recipeName;

    @JsonProperty("portions")
    private Integer portions;

    @JsonProperty("calories")
    private Integer calories;

    @JsonProperty("instructions")
    private String instructions;

    @JsonProperty(value = "recipeIngredients", access = JsonProperty.Access.WRITE_ONLY)
    private List<IngredientRecipeResource> ingredients;
}
