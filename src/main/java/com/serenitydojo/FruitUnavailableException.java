package com.serenitydojo;

public class FruitUnavailableException extends RuntimeException {
    public FruitUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
