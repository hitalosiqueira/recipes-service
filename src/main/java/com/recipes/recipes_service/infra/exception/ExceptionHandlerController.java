package com.recipes.recipes_service.infra.exception;

import com.recipes.recipes_service.infra.error.ErrorCode;
import com.recipes.recipes_service.infra.error.ErrorResource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
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

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        NotFoundException ex = new NotFoundException(ErrorCode.NOT_FOUND_URI);

        String code = ex.getError().getCode();

        return buildResponseEntity(new ErrorResource(HttpStatus.NOT_FOUND, code, ex));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleBadRequest(Exception exception) {
        InternalServerError ex = new InternalServerError(ErrorCode.INTERNAL_SERVER_ERROR);

        String code = ex.getError().getCode();

        return buildResponseEntity(new ErrorResource(HttpStatus.INTERNAL_SERVER_ERROR, code, ex));
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResource error) {
        return new ResponseEntity<>(error, error.getStatus());
    }
}
