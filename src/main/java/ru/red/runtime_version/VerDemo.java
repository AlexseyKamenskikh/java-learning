package ru.red.runtime_version;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VerDemo {
    public static void main(String[] args) {
        Runtime.Version version = Runtime.version();
        log.info("Счетчик выпусков фунциональных средств: {}", version.feature());
        log.info("Счетчик промежуточных выпусков: {}", version.interim());
        log.info("Счетчик выпусков обновлений: {}", version.update());
        log.info("Счетчик выпусков исправлений: {}", version.patch());
    }
}
