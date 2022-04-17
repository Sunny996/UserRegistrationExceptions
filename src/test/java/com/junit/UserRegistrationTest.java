package com.junit;


import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.regex.Pattern;

public class UserRegistrationTest {
    @Test
    public void givenFirstNameWhenProperShouldReturnTrue() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = Pattern.matches(userRegistration.firstName, "Akash");
        Assert.assertEquals(true, result);

    }

    @Test
    public void givenFirstNameWhenShortShouldReturnFalse() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = Pattern.matches(userRegistration.firstName, "Ak");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenLastNameWhenProperShouldReturnTrue() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = Pattern.matches(userRegistration.lastName, "Satla");
        Assert.assertEquals(true, result);

    }

    @Test
    public void givenLastNameWhenShortShouldReturnFalse() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = Pattern.matches(userRegistration.lastName, "Sa");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenPhoneNumberWhenProperShouldReturnTrue() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = Pattern.matches(userRegistration.phoneNumber, "91 9676443328");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenPhoneNumberWhenShortShouldReturnFalse() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = Pattern.matches(userRegistration.phoneNumber, "976443328");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenPasswordWhenProperShouldReturnTrue() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = Pattern.matches(userRegistration.password, "Ajv12@jafvc");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenPasswordWhenShortShouldReturnFalse() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = Pattern.matches(userRegistration.password, "Aakjf1");
        Assert.assertEquals(false, result);
    }
    @Test
    public void givenSomeEmailSamplesShoudlClearThemAll() {
        UserRegistration userRegistration = new UserRegistration();
        String email = userRegistration.email;
        String[] trueArray = {"abc@yahoo.com", "abc-100@yahoo.com", "abc.100@yahoo.com", "abc111@abc.com", "abc-100@abc.net",
                "abc.100@abc.com.au", "abc@1.com", "abc@gmail.com.com", "abc+100@gmail.com"};
        String[] falseArray = {"abc", "abc@.com.my", "abc123@gmail.a", "abc123@.com", "abc123@.com.com", ".abc@abc.com", "abc()*@gmail.com"
                , "abc@%*.com", "abc..2002@gmail.com", "abc.@gmail.com", "abc@abc@gmail.com", "abc@gmail.com.1a", "abc@gmail.com.aa.au"};
        boolean flag1 = true;
        for (String str : trueArray) {
            if (!str.matches(userRegistration.email))
                flag1 = false;
        }
        boolean flag2 = true;
        for (String st : falseArray) {
            if (st.matches(userRegistration.email))
                flag2 = false;
        }
        Assert.assertTrue(flag1 && flag2);
    }
}
