package com.recipes.recipes_service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Recipe {

    private String recipeName;

    private Integer portions;

    private Integer calories;

    private String instructions;

    private List<Ingredient> ingredients;
}
