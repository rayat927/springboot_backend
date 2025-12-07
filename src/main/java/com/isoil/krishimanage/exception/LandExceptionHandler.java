package com.isoil.krishimanage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.isoil.krishimanage.model.Land;


@ControllerAdvice
public class LandExceptionHandler {

    @ExceptionHandler(value = {LandNotFoundException.class})
    public ResponseEntity<Object> hand
            (LandNotFoundException landNotFoundException)
    {
        LandException landException = new LandException(
                landNotFoundException.getMessage(),
                landNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(landException, HttpStatus.NOT_FOUND);
    }
}