package dev.vishal.productservice.exceptions;

public class NotFoundException extends Exception{

    private String message;

    public NotFoundException(String message) {
        super(message);
    }
}
