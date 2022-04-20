package com.junit;

import java.util.regex.Pattern;
@FunctionalInterface
interface UserInputValidation{
    boolean validate(String regex, String input);
}

public class UserRegistration {
    public static UserInputValidation validation=(regex, input)->{
        Pattern pattern=Pattern.compile(regex);
        return pattern.matcher(input).matches();
    };

    public boolean validateEmail(String email) throws UserRegistrationException {
        Pattern pattern = Pattern.compile("^[a-z0-9_+-]+((\\.)[a-z0-9]+)?(\\@)[a-z0-9]+(\\.)[a-z]{2,4}((\\.)[a-z]{2,4})?$");
        if (!UserRegistration.validation.validate("^[a-z0-9_+-]+((\\.)[a-z0-9]+)?(\\@)[a-z0-9]+(\\.)[a-z]{2,4}((\\.)[a-z]{2,4})?$",email))
            throw new UserRegistrationException("Invalid Email Address", UserRegistrationException.ExceptionType.INVALID_EMAIL);
        return true;
    }

    public boolean validateFirstName(String firstName) throws UserRegistrationException {
        if (!UserRegistration.validation.validate("^[A-Z][a-z]{2,}$",firstName))
            throw new UserRegistrationException("Invalid First Name", UserRegistrationException.ExceptionType.INVALID_FIRST_NAME);
        return true;
    }

    public boolean validateLastName(String lastName) throws UserRegistrationException {
        if (!UserRegistration.validation.validate("^[A-Z][a-z]{2,}$",lastName))
            throw new UserRegistrationException("Invalid Last Name", UserRegistrationException.ExceptionType.INVALID_LAST_NAME);
        return true;
    }

    public boolean validatePhoneNumber(String phoneNumber) throws UserRegistrationException {
        if (!UserRegistration.validation.validate("^[1-9][0-9]{0,2} [1-9][0-9]{9}$",phoneNumber))
            throw new UserRegistrationException("Invalid Phone Number", UserRegistrationException.ExceptionType.INVALID_PHONE_NUMBER);
        return true;
    }

    public boolean validatePassword(String password) throws UserRegistrationException {
        if (!UserRegistration.validation.validate("^(?=.*[A-Z])(?=.*\\d)(?=[a-zA-Z0-9]*[@$#%^&!?][a-zA-Z0-9]*$)[a-zA-Z0-9!@#$^&*]{8,}$",password))
            throw new UserRegistrationException("Invalid Password", UserRegistrationException.ExceptionType.INVALID_PASSWORD);
        return true;
    }

}
