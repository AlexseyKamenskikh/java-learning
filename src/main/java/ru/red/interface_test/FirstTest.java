package ru.red.interface_test;

public interface FirstTest {
    int getNumber();
    default String getString() {
        return "";
    }
    static int getDefaultNumber() {
        return 0;
    }
}
