package com.isoil.krishimanage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.isoil.krishimanage.model.Crop;


@ControllerAdvice
public class CropExceptionHandler {


    @ExceptionHandler(value = {CropNotFoundException.class})
    public ResponseEntity<Object> hand
            (CropNotFoundException cropNotFoundException)
    {
        CropException cropException = new CropException(
                cropNotFoundException.getMessage(),
                cropNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(cropException, HttpStatus.NOT_FOUND);
    }
/*******  261b6ea8-eed7-427f-92e7-5d0615001ea6  *******/
}