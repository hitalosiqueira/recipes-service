package com.recipes.recipes_service.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@Entity
@Table(name = "INGREDIENT")
public class IngredientEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    private Long ingredient_id;

    @Column(name = "INGREDIENT_NAME", nullable = false)
    private String ingredientName;

    @OneToMany(mappedBy = "primaryKey.ingredientEntity", cascade = CascadeType.ALL)
    private List<RecipeIngredientEntity> recipes;
}
