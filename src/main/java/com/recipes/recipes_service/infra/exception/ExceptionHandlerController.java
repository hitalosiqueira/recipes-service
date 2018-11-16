package com.recipes.recipes_service.infra.exception;

import com.recipes.recipes_service.infra.error.ErrorResource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequest(BadRequestException ex) {
        String code = ex.getError().getCode();

        return buildResponseEntity(new ErrorResource(HttpStatus.BAD_REQUEST, code, ex));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleBadRequest(NotFoundException ex) {
        String code = ex.getError().getCode();

        return buildResponseEntity(new ErrorResource(HttpStatus.NOT_FOUND, code, ex));
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResource error) {
        return new ResponseEntity<>(error, error.getStatus());
    }
}
