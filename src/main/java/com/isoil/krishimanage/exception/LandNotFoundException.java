package com.isoil.krishimanage.exception;

public class LandNotFoundException extends RuntimeException {

    public LandNotFoundException(String message) {
        super(message);
    }

    public LandNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}