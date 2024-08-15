package com.menumaster.menumaster.exception.controller;

import com.menumaster.menumaster.exception.domain.entity.ErrorDescription;
import com.menumaster.menumaster.exception.type.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDescription> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        ErrorDescription errorResponse = new ErrorDescription(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
