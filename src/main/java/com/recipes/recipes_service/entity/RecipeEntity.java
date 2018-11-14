package com.recipes.recipes_service.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Data
@Entity
@Table(name = "RECIPE")
public class RecipeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "RECIPE_NAME", nullable = false)
    private String recipeName;

    @Column(name = "PORTIONS", nullable = false)
    private Integer portions;

    @Column(name = "CALORIES", nullable = false)
    private Integer calories;

    @Column(name = "INSTRUCTIONS", nullable = false)
    private String instructions;

    @OneToMany(mappedBy = "primaryKey.recipeEntity", cascade = CascadeType.ALL)
    private Set<RecipeIngredientEntity> recipeIngredientEntities;


}
