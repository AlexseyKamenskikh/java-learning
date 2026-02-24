package ru.red.switch_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SwitchExpr {
    private static final Logger log = LoggerFactory.getLogger(SwitchExpr.class);

    public static void main(String[] args) {
        int eventCode = 6010;
        int priorityLevel = switch (eventCode) {
            case 1000, 1205, 8900 -> 1;
            case 2000, 6010, 9128 -> 2;
            case 1002, 7023, 9300 -> 3;
            default -> 0;
        };
        log.info("Уровень приоритета для кода события {} равен {}", eventCode, priorityLevel);
    }
}
