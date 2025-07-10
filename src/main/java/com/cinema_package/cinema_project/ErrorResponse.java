package com.cinema_package.cinema_project;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Sending error details
 * in HTTP responses when an exception occurs.
 * Used in GlobalExceptionHAndlers
 * Apply get() and set() method for all fields
 * Includes:
 * - message: A human-readable error message
 * - timestamp: The time the error occurred
 */
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    
    // A brief description of the error
    private String message;

    // The timestamp when the error occurred
    private LocalDateTime timestamp;
}