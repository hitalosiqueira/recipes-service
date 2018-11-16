package com.recipes.recipes_service.infra.error;

public enum ErrorCode {
    BAD_REQUEST_INGREDIENTS_REQUIRED("000", "Uma receita deve possuir pelo menos 1 ingrediente"),
    BAD_REQUEST_NAME_REQUIRED("001", "O nome da receita é obrigatório"),
    BAD_REQUEST_PORTIONS_REQUIRED("002", "O número de porções é obrigatório"),
    BAD_REQUEST_PORTIONS_INVALID("003", "Número de porções inválido. Deve ser pelo menos 1"),
    BAD_REQUEST_CALORIES_REQUIRED("004", "O número de calorias é obrigatório"),
    BAD_REQUEST_NAME_INVALID("005", "Nome inválido"),
    BAD_REQUEST_CALORIES_INVALID("006", "Número de calorias inválido. Deve ser pelo menos 0"),
    BAD_REQUEST_INSTRUCTIONS_REQUIRED("007", "As instruções são obrigatórias"),
    BAD_REQUEST_INGREDIENT_NAME_REQUIRED("008", "O nome do ingrediente é obrigatório"),
    BAD_REQUEST_INGREDIENT_AMOUNT_REQUIRED("009", "A quantidade é obrigatória"),

    NOT_FOUND_RECIPE("010", "Receita não encontrada"),
    NOT_FOUND_INGREDIENT("011", "Ingrediente não encontrado"),
    NOT_FOUND_URI("012", "Uri não encontrada"),

    INTERNAL_SERVER_ERROR("111", "Um erro inesperado ocorreu");


    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
