package ru.red.enum_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnumDemoApple {
    private static final Logger log = LoggerFactory.getLogger(EnumDemoApple.class);

    public static void main(String[] args) {
        AppleTest appleTest1, appleTest2, appleTest3;
        //Получить все порядковые нромера с применением ordinal
        for (AppleTest a:AppleTest.values()) {
            log.info("{} {}", a, a.ordinal());
        }

        appleTest1 = AppleTest.RED_DEL;
        appleTest2 = AppleTest.GOLDEN_DEL;
        appleTest3 = AppleTest.RED_DEL;

        //Демонстрация использования compareTo() и equals()
        if (appleTest1.compareTo(appleTest2) < 0) {
            log.info(appleTest1 + " находится перед " + appleTest2);
        }

        if (appleTest1.compareTo(appleTest2) > 0) {
            log.info(appleTest2 + " находится перед " + appleTest1);
        }

        if (appleTest1.compareTo(appleTest3) == 0) {
            log.info(appleTest1 + " равно " + appleTest3);
        }

        if (!appleTest1.equals(appleTest2)) {
            log.info("Нет равенства!");
        }

        if (appleTest1.equals(appleTest3)) {
            log.info(appleTest1 + " равно " + appleTest3);
        }

        if (appleTest1 == appleTest3) {
            log.info(appleTest1 + "==" + appleTest3 );
        }
    }
}
