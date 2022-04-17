package com.JUnit;

public class UserRegistration {
    public String firstName = "^[A-Z][a-z]{2,}$";
    public String lastName = "^[A-Z][a-z]{2,}$";
    public String email = "^[a-z0-9_+-]+((\\.)[a-z0-9]+)?(\\@)[a-z0-9]+(\\.)[a-z]{2,4}((\\.)[a-z]{2,4})?$";
    public String phoneNumber = "^[1-9][0-9]{0,2} [1-9][0-9]{9}$";

}
