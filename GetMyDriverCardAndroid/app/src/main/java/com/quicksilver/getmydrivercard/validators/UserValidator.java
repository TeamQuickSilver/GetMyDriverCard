package com.quicksilver.getmydrivercard.validators;

import com.quicksilver.getmydrivercard.models.User;

import org.apache.commons.validator.routines.EmailValidator;

public class UserValidator implements Validator<User> {
    @Override
    public boolean isValid(User object) {
        return isEmailValid(object.getEmail()) && isPasswordValid(object.getPassword());
    }

    private boolean isPasswordValid(String password) {
        return password != null && password.length() >= 6 && password.length() <= 20;
    }

    private boolean isEmailValid(String email) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        return email != null && emailValidator.isValid(email);
    }
}
