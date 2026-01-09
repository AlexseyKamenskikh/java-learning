package ru.red.thread_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrentThreadDemo {
    private static final Logger log = LoggerFactory.getLogger(CurrentThreadDemo.class);
    private static final Integer THREAD_PRIORITY = 7;

    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        log.info("Текущий поток: {}", currentThread);

        currentThread.setName("My Thread");
        currentThread.setPriority(THREAD_PRIORITY);
        log.info("После изменеия имени и приоритета: {}", currentThread);

        try {
            for (int n = 5; n > 0; n--) {
                log.info("{}", n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            log.info("Главный поток прерван");
            throw new RuntimeException(e);
        }
    }
}
