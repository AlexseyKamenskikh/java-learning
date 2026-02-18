package ru.red.lambda_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LambdasAsArgumentsDemo {
    private static final Logger log = LoggerFactory.getLogger(LambdasAsArgumentsDemo.class);

    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Lanbdas add power to Java";
        String outStr;
        log.info("Исходная строка: {}", inStr);

        outStr = stringOp((str) -> str.toUpperCase(), inStr);
        log.info("Строка в верхнем регистре: {}", outStr);

        outStr = stringOp((str) -> {
            StringBuilder result = new StringBuilder();
            int i;
            for (i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ') {
                   result.append(str.charAt(i));
                }
            }
            return result.toString();
        }, inStr);
        log.info("Строка после удаления пробелов: {}", outStr);

        StringFunc reverse = ((str) -> {
            StringBuilder result = new StringBuilder();
            int i;

            for (i = str.length() - 1; i >= 0; i--) {
                result.append(str.charAt(i));
            }
            return result.toString();
        });
        log.info("Строка с противоположным порядком следования символов: {}", stringOp(reverse, inStr));
    }
}
