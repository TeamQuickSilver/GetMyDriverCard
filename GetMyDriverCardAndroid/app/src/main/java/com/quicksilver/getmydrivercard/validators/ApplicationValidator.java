package com.quicksilver.getmydrivercard.validators;

import com.quicksilver.getmydrivercard.models.Application;

import java.util.Calendar;

public class ApplicationValidator implements Validator<Application> {
    @Override
    public boolean isValid(Application object) {
        boolean isPhoneNumberValid = isPhoneNumberValid(object.getPerson().getPhoneNumber());
        boolean isCardNumberValid = isCardNumberValid(object.getPerson()
                .getIdentityCard().getIdentityCardNumber()) &&
                isCardNumberValid(object.getPerson().getDrivingLicense().getDrivingLicenseNumber());
        boolean isPersonalNumberValid = isPersonalNumberValid(object.getPerson().getIdentityCard().getPersonalNumber());
        boolean isPersonFirstNameValid = isPersonFirstNameValid(object.getPerson().getIdentityCard().getFirstName());
        boolean isPersonFathersNameValid = isPersonFathersNameValid(object.getPerson().getIdentityCard().getFathersName());
        boolean isPersonLastNameValid = isPersonLastNameValid(object.getPerson().getIdentityCard().getLastName());
        boolean isIssuedByValid = isIssuedByValid(object.getPerson().getIdentityCard().getIssuedBy())
                && isIssuedByValid(object.getPerson().getDrivingLicense().getIssuedBy());


        return isPhoneNumberValid && isCardNumberValid && isPersonalNumberValid
                && isPersonFirstNameValid && isPersonFathersNameValid && isPersonLastNameValid
                && isIssuedByValid;
    }

    private boolean isIssuedByValid(String issuedBy) {
        return issuedBy != null && issuedBy.length() > 5 && issuedBy.length() <= 20;
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
        int[] weights = {2,4,8,5,10,9,7,3,6};
        String personalNumberStr = personalNumber + "";

        if(personalNumberStr.length() != 10) {
            return false;
        }

        int year = Integer.parseInt(personalNumberStr.substring(0, 2));
        int month = Integer.parseInt(personalNumberStr.substring(2, 2));
        int day = Integer.parseInt(personalNumberStr.substring(4, 2));

        boolean isDateValid = isDateValid(day, month, year);

        if(!isDateValid) {
            return false;
        }

        int checkSum = Integer.parseInt(personalNumberStr.substring(9, 1));
        int personalNumberSum = 0;
        for (int i = 0; i < 9; i++) {
            personalNumberSum += Integer.parseInt(personalNumberStr.substring(i, 1))
                    * weights[i];
        }

        int validCheckSum = personalNumberSum % 11;
        if(validCheckSum == 10) {
            validCheckSum = 0;
        }

        return checkSum == validCheckSum;
    }

    private boolean isDateValid(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.set(year, month - 1, day);

        try {
            calendar.getTime();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isCardNumberValid(Long identityCardNumber) {
        String identityCardNumberStr = identityCardNumber + "";
        return identityCardNumberStr.length() == 9;
    }

    private boolean isPhoneNumberValid(Long phoneNumber) {
        String phoneNumberStr = phoneNumber + "";
        return phoneNumberStr.length() == 10;
    }
}
