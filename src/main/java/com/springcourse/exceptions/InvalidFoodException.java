package com.springcourse.exceptions;

public class InvalidFoodException extends RuntimeException{

    public InvalidFoodException(String message) {
        super(message);
    }

}
