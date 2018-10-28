package com.quicksilver.getmydrivercard.validators;

import com.quicksilver.getmydrivercard.models.Application;

public class ApplicationValidator implements Validator<Application> {
    @Override
    public boolean isValid(Application object) {
        boolean isPhoneNumberValid = isPhoneNumberValid(object.getPerson().getPhoneNumber());
        boolean isIdentityCardNumberValid = isIdentityCardNumberValid(object.getPerson()
                .getIdentityCard().getIdentityCardNumber());
        boolean isPersonalNumberValid = isPersonalNumberValid(object.getPerson().getIdentityCard().getPersonalNumber());
        boolean isPersonFirstNameValid = isPersonFirstNameValid(object.getPerson().getIdentityCard().getFirstName());
        boolean isPersonFathersNameValid = isPersonFathersNameValid(object.getPerson().getIdentityCard().getFathersName());
        boolean isPersonLastNameValid = isPersonLastNameValid(object.getPerson().getIdentityCard().getLastName());


        return isPhoneNumberValid && isIdentityCardNumberValid && isPersonalNumberValid
                && isPersonFirstNameValid && isPersonFathersNameValid && isPersonLastNameValid;
    }

    private boolean isPersonLastNameValid(String lastName) {
        return lastName.length() >= 2 && lastName.length() <= 20;
    }

    private boolean isPersonFathersNameValid(String fathersName) {
        return fathersName.length() >= 2 && fathersName.length() <= 30;
    }

    private boolean isPersonFirstNameValid(String firstName) {
        return firstName.length() >= 2 && firstName.length() <= 20;
    }

    private boolean isPersonalNumberValid(Long personalNumber) {
        return false;
    }

    private boolean isIdentityCardNumberValid(Long identityCardNumber) {
        return false;
    }

    private boolean isPhoneNumberValid(Long phoneNumber) {
        return false;
    }
}
