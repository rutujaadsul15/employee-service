package com.employee.ControllerAdvice;

import com.employee.CustomException.NoCompanyExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdviceHandler {

    @ExceptionHandler(NoCompanyExistException.class)
    public ResponseEntity<Object> handleNoCompanyException(NoCompanyExistException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
