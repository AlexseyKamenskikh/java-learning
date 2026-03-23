package ru.red.parser_utils;


import lombok.experimental.UtilityClass;

@UtilityClass
public class NameParserUtils {

    private static final int LAST_NAME_INDEX = 0;
    private static final int FIRST_NAME_INDEX = 1;
    private static final int MIDDLE_NAME_INDEX = 2;

    /**
     * Основной метод парсинга ФИО из строки с префиксом
     */
    public static FullName parseFullNameWithPrefix(String fullNameWithPrefix, String prefix) {
        String withoutPrefix = removePrefix(fullNameWithPrefix, prefix);
        String[] parts = splitIntoParts(withoutPrefix);

        String lastName = extractPart(parts, LAST_NAME_INDEX);
        String firstName = extractPart(parts, FIRST_NAME_INDEX);
        String middleName = extractPart(parts, MIDDLE_NAME_INDEX);

        return new FullName(lastName, firstName, middleName);
    }

    /**
     * Валидация наличия обязательных частей ФИО
     */
    public static boolean isValidFullName(FullName fullName, boolean requireFirstName) {
        if (fullName == null) {
            return false;
        }
        if (!fullName.hasLastName()) {
            return false;
        }
        return !requireFirstName || fullName.hasFirstName();
    }

    /**
     * Удаляет префикс (например, "ИП") из строки с ФИО
     */
    private String removePrefix(String fullNameWithPrefix, String prefix) {
        if (fullNameWithPrefix == null || fullNameWithPrefix.isEmpty()) {
            return "";
        }
        return fullNameWithPrefix.replaceFirst("^" + prefix + "\\s+", "").trim();
    }

    /**
     * Разбивает строку на массив частей по пробелам
     */
    private String[] splitIntoParts(String text) {
        if (text == null || text.isEmpty()) {
            return new String[0];
        }
        return text.split("\\s+");
    }

    /**
     * Извлекает часть ФИО по индексу с проверкой границ
     */
    private String extractPart(String[] parts, int index) {
        if (parts == null || index < 0 || index >= parts.length) {
            return "";
        }
        return parts[index];
    }
}
