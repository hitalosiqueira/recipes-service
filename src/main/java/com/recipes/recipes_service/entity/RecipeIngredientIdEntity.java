package com.recipes.recipes_service.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class RecipeIngredientIdEntity implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private RecipeEntity recipeEntity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private IngredientEntity ingredientEntity;

}
