package ru.red.throwable_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThrowsDemo {
    private static final Logger log = LoggerFactory.getLogger(ThrowsDemo.class);

    static void throwOne() throws IllegalAccessException {
        log.info("Внутри throwOne().");
        throw new IllegalAccessException("Демонстрация");
    }

    public static void main(String[] args) {
        try {
            throwOne();
        } catch (IllegalAccessException  e) {
            log.info("Перехвачено {}", String.valueOf(e));
        }
    }
}
