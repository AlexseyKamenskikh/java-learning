package ru.red.parser_utils;

import org.apache.commons.lang3.StringUtils;

// DTO для хранения ФИО
public record FullName(String lastName, String firstName, String middleName) {

    public boolean hasLastName() {
        return StringUtils.isNotBlank(lastName);
    }

    public boolean hasFirstName() {
        return StringUtils.isNotBlank(firstName);
    }

    public boolean hasMiddleName() {
        return StringUtils.isNotBlank(middleName);
    }


    @Override
    public String toString() {
        return "FullName{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }
}