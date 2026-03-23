package ru.red.string_conversion;

import lombok.extern.slf4j.Slf4j;

/**
 * Преобразование целого числа в двоичную, шестнадцатеричную и восмиричную строку.
 */
@Slf4j
public class StringConversions {
    public static void main(String[] args) {
        int num = 19648;
        log.info("{} в двоичной форме: {}", num, Integer.toBinaryString(num));
        log.info("{} в восьмеричной форме: {}", num, Integer.toOctalString(num));
        log.info("{} в шестнадцатиричной форме: {}", num, Integer.toHexString(num));
    }
}
