package ru.red.thread_test.synch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CallMe {
    private static final Logger log = LoggerFactory.getLogger(CallMe.class);
    private int count;

    //Для теста убрать synchronized, чтоб получить не корректный вывод и состояние гонки
    public synchronized void call(String msg) {
        count++;
        log.info("[{} - {}]", msg, count);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Поток прерван: {}", e.getMessage());
        }
        log.info("Всегда выводиться последовательность - {}", count);
    }
}
