package com.tihor.practice.advice;

import com.tihor.practice.exception.EmployeeNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type Custom controller advice.
 */
@ControllerAdvice
public class CustomControllerAdvice {
    /**
     * Handle employee not found exception response entity.
     *
     * @return the response entity
     */
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity handleEmployeeNotFoundException() {
        return ResponseEntity.notFound().build();
    }
}
