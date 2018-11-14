package com.recipes.recipes_service.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "RECIPE_INGREDIENT")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.ingredientEntity",
                joinColumns = @JoinColumn(name = "INGREDIENT_ID")),
        @AssociationOverride(name = "primaryKey.recipeEntity",
                joinColumns = @JoinColumn(name = "RECIPE_ID")) })
public class RecipeIngredientEntity {

    @EmbeddedId
    private RecipeIngredientIdEntity primaryKey;

    @Transient
    private IngredientEntity ingredientEntity;

    @Transient
    private RecipeEntity recipeEntity;

    @Column(name = "AMOUNT")
    private String amount;
}
