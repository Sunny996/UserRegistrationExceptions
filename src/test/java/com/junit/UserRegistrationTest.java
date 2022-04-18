package com.junit;


import org.junit.jupiter.api.Test;
import org.testng.Assert;



public class UserRegistrationTest {
    @Test
    public void givenFirstNameWhenInvalidShouldReturnTrue() {
        UserRegistration userRegistration = new UserRegistration();
        try {
            boolean result = userRegistration.validateFirstName("akash");

        } catch (UserRegistrationException e) {
            Assert.assertEquals(UserRegistrationException.ExceptionType.INVALID_FIRST_NAME, e.type);
        }
    }

    @Test
    public void givenlastNameWhenInvalidShouldReturnTrue() {
        UserRegistration userRegistration = new UserRegistration();
        try {
            boolean result = userRegistration.validateLastName("sa");

        } catch (UserRegistrationException e) {
            Assert.assertEquals(UserRegistrationException.ExceptionType.INVALID_LAST_NAME, e.type);
        }
    }

    @Test
    public void givenPhoneNumberWhenInvalidShouldReturnTrue() {
        UserRegistration userRegistration = new UserRegistration();
        try {
            boolean result = userRegistration.validatePhoneNumber("594");

        } catch (UserRegistrationException e) {
            Assert.assertEquals(UserRegistrationException.ExceptionType.INVALID_PHONE_NUMBER, e.type);
        }
    }

    @Test
    public void givenPasswordWhenInvalidShouldReturnTrue() {
        UserRegistration userRegistration = new UserRegistration();
        try {
            boolean result = userRegistration.validatePassword("wjvkjsfv");

        } catch (UserRegistrationException e) {
            Assert.assertEquals(UserRegistrationException.ExceptionType.INVALID_PASSWORD, e.type);
        }
    }

    @Test
    public void givenFirstNameWhenProperShouldReturnTrue() throws UserRegistrationException {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validateFirstName("Akash");
        Assert.assertEquals(true, result);

    }
    @Test
    public void givenLastNameWhenProperShouldReturnTrue() throws UserRegistrationException {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validateLastName("Satla");
        Assert.assertEquals(true, result);

    }


    @Test
    public void givenPhoneNumberWhenProperShouldReturnTrue() throws UserRegistrationException {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validatePhoneNumber("91 9676443328");
        Assert.assertEquals(true, result);
    }


    @Test
    public void givenPasswordWhenProperShouldReturnTrue() throws UserRegistrationException {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validatePassword("Ajv12@jafvc");
        Assert.assertEquals(true, result);
    }


    @Test
    public void givenSomeEmailSamplesShoudlClearThemAll() throws UserRegistrationException {
        UserRegistration userRegistration = new UserRegistration();
        String[] trueArray = {"abc@yahoo.com", "abc-100@yahoo.com", "abc.100@yahoo.com", "abc111@abc.com", "abc-100@abc.net",
                "abc.100@abc.com.au", "abc@1.com", "abc@gmail.com.com", "abc+100@gmail.com"};
        String[] falseArray = {"abc", "abc@.com.my", "abc123@gmail.a", "abc123@.com", "abc123@.com.com", ".abc@abc.com", "abc()*@gmail.com"
                , "abc@%*.com", "abc..2002@gmail.com", "abc.@gmail.com", "abc@abc@gmail.com", "abc@gmail.com.1a", "abc@gmail.com.aa.au"};
        boolean flag1 = true;
        for (String str : trueArray) {
            if (!userRegistration.validateEmail(str))
                flag1 = false;
        }
        boolean flag2 = true;
        for (String st : falseArray) {
            try {
                if (userRegistration.validateEmail(st))
                    flag2 = false;
            } catch (UserRegistrationException e) {
                Assert.assertEquals(UserRegistrationException.ExceptionType.INVALID_EMAIL, e.type, st);
            }
        }
        Assert.assertTrue(flag1 );
    }
}
