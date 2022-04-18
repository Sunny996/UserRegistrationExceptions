package com.junit;

public class UserRegistrationException extends Exception{
    enum ExceptionType{
        INVALID_FIRST_NAME,INVALID_LAST_NAME,INVALID_EMAIL, INVALID_PHONE_NUMBER,INVALID_PASSWORD
    }
    ExceptionType type;

    public UserRegistrationException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
