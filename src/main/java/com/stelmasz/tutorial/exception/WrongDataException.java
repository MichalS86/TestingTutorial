package com.stelmasz.tutorial.exception;

public class WrongDataException extends RuntimeException {

    public WrongDataException(String errorMessage) {
        super(errorMessage);
    }
}
