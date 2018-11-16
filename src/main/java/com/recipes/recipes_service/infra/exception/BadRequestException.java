package com.recipes.recipes_service.infra.exception;

import com.recipes.recipes_service.infra.error.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class BadRequestException extends RuntimeException{
    private ErrorCode error;

    public BadRequestException(ErrorCode error) {
        super(error.getMessage());
        this.error = error;
    }
}
