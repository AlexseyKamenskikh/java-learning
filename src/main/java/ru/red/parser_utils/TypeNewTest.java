package ru.red.parser_utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TypeNewTest {

    public void testNew(String nameFull, String type) {
        if (TypeCounterpartyEnum.IP.name().equals(type)) {
            String fullNameWithoutPrefix = nameFull.replaceFirst("^" + TypeCounterpartyEnum.IP.getShortName() + "\\s+", "").trim();

            // Разбиваем оставшуюся строку на части по пробелам
            String[] nameParts = fullNameWithoutPrefix.split("\\s+");

            String lastName = "";    // Фамилия
            String firstName = "";   // Имя
            String middleName = "";  // Отчество

            if (nameParts.length >= 1) {
                lastName = nameParts[0];  // Иванов
            }
            if (nameParts.length >= 2) {
                firstName = nameParts[1]; // Иван
            }
            if (nameParts.length >= 3) {
                middleName = nameParts[2]; // Иванович
            }

            log.info("Фамилия: {}", lastName);
            log.info("Имя: {}", firstName);
            log.info("Отчество: {}", middleName);
        }
    }

    public void testNew2(String nameFull, String type) {
        if (TypeCounterpartyEnum.IP.name().equals(type)) {
            // Парсим ФИО
            FullName fullName = NameParserUtils.parseFullNameWithPrefix(
                    nameFull,
                    TypeCounterpartyEnum.IP.getShortName()
            );

            // Валидация (опционально)
            if (!NameParserUtils.isValidFullName(fullName, true)) {
                System.out.println("Ошибка: неполные данные ФИО");
                return;
            }

            log.info("Фамилия: {}", fullName.lastName());
            log.info("Имя: {}", fullName.firstName());
            log.info("Отчество: {}", fullName.middleName());
        }
    }
}

