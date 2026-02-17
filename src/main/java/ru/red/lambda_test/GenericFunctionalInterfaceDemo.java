package ru.red.lambda_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericFunctionalInterfaceDemo {
    private static final Logger log = LoggerFactory.getLogger(GenericFunctionalInterfaceDemo.class);

    public static void main(String[] args) {
        SomeFunc<String> reverse = (str) -> {
            log.info("Строка: {}", str);
            String result = "";
            int i;
            for (i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };
        log.info("Противоположный порядок: {}", reverse.func("Lambda"));

        SomeFunc<Integer> factorial = (n) -> {
            log.info("Факториал  числа: {}", n);
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = i * result;
            }
            return result;
        };
        log.info("Равен: {}", factorial.func(3));
        log.info("Равен: {}", factorial.func(5));
    }
}
