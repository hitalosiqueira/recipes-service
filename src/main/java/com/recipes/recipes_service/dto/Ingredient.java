package com.recipes.recipes_service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ingredient {

    private Long id;
    private String ingredientName;
    private String amount;
}
