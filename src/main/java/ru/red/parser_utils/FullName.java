package ru.red.parser_utils;

// DTO для хранения ФИО
public record FullName(String lastName, String firstName, String middleName) {

    public boolean hasLastName() {
        return lastName != null && !lastName.isEmpty();
    }

    public boolean hasFirstName() {
        return firstName != null && !firstName.isEmpty();
    }

    public boolean hasMiddleName() {
        return middleName != null && !middleName.isEmpty();
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