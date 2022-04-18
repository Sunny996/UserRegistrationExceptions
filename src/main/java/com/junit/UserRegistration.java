package com.junit;

import java.util.regex.Pattern;

public class UserRegistration {

    public boolean validateEmail(String email) throws UserRegistrationException {
        Pattern pattern = Pattern.compile("^[a-z0-9_+-]+((\\.)[a-z0-9]+)?(\\@)[a-z0-9]+(\\.)[a-z]{2,4}((\\.)[a-z]{2,4})?$");
        if (!pattern.matcher(email).matches())
            throw new UserRegistrationException("Invalid Email Address", UserRegistrationException.ExceptionType.INVALID_EMAIL);
        return pattern.matcher(email).matches();
    }

    public boolean validateFirstName(String firstName) throws UserRegistrationException {
        Pattern pattern = Pattern.compile("^[A-Z][a-z]{2,}$");
        if (!pattern.matcher(firstName).matches())
            throw new UserRegistrationException("Invalid First Name", UserRegistrationException.ExceptionType.INVALID_FIRST_NAME);
        return pattern.matcher(firstName).matches();
    }

    public boolean validateLastName(String lastName) throws UserRegistrationException {
        Pattern pattern = Pattern.compile("^[A-Z][a-z]{2,}$");
        if (!pattern.matcher(lastName).matches())
            throw new UserRegistrationException("Invalid Last Name", UserRegistrationException.ExceptionType.INVALID_LAST_NAME);
        return pattern.matcher(lastName).matches();
    }

    public boolean validatePhoneNumber(String phoneNumber) throws UserRegistrationException {
        Pattern pattern = Pattern.compile("^[1-9][0-9]{0,2} [1-9][0-9]{9}$");
        if (!pattern.matcher(phoneNumber).matches())
            throw new UserRegistrationException("Invalid Phone Number", UserRegistrationException.ExceptionType.INVALID_PHONE_NUMBER);
        return pattern.matcher(phoneNumber).matches();
    }

    public boolean validatePassword(String password) throws UserRegistrationException {
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)(?=[a-zA-Z0-9]*[@$#%^&!?][a-zA-Z0-9]*$)[a-zA-Z0-9!@#$^&*]{8,}$");
        if (!pattern.matcher(password).matches())
            throw new UserRegistrationException("Invalid Password", UserRegistrationException.ExceptionType.INVALID_PASSWORD);
        return pattern.matcher(password).matches();
    }

}
