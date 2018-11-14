package com.recipes.recipes_service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ingredient {

    private String ingredientName;
    private String amount;
}
