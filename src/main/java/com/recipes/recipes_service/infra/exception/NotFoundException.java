package com.recipes.recipes_service.infra.exception;

import com.recipes.recipes_service.infra.error.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NotFoundException extends RuntimeException{
    private ErrorCode error;

    public NotFoundException(ErrorCode error) {
        super(error.getMessage());
        this.error = error;
    }
}
