package com.recipes.recipes_service.infra.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorResource {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String code;
    private HttpStatus status;
    private String message;

    private ErrorResource() {
        timestamp = LocalDateTime.now();
    }

    public ErrorResource(HttpStatus status, String code, Throwable ex) {
        this();
        this.code = code;
        this.status = status;
        this.message = ex.getLocalizedMessage();
    }
}
