package com.cinema_package.cinema_project;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * To define global exception handler for the Cinema Project.
 * Catches and handles exceptions thrown across the entire application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles MovieNotFoundException specifically.
     * Returns a 404 NOT FOUND response with error details.
     */
    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(MovieNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles any generic Exception not caught by other specific handlers.
     * Returns a 500 INTERNAL SERVER ERROR response with a generic error message.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse("Something is wrong", LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
