package ru.red.parser_utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TypeCounterpartyEnum {
    IP("Индивидуальный предприниматель", "ИП"),
    UL("Юридическое лицо", "ЮЛ");

    private final String value;
    private final String shortName;
}
