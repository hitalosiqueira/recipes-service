package com.recipes.recipes_service.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@JsonPropertyOrder({
        "name"
})
@Relation(value="ingredient", collectionRelation="ingredients")
public class IngredientResource extends ResourceSupport {

    @JsonProperty("name")
    private String ingredientName;

}
