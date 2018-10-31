package com.quicksilver.getmydrivercard.validators;

public interface Validator<T> {
    boolean isValid(T object);
}
