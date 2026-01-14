package ru.red.thread_test.deadlock_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeadlockBTest {
    private static final Logger log = LoggerFactory.getLogger(DeadlockBTest.class);

    synchronized void bar(DeadlockATest bTest) {
        String name = Thread.currentThread().getName();
        log.info("{} вошел в DeadlockBTest.bar", name);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Поток превран: {}", e.getMessage());
        }
        log.info("{} пытается вызвать DeadlockATest.last()", name);
        bTest.last();
    }

    //Убрать synchronized чтоб исключить взаимоблокировку
    synchronized void last() {
        log.info("Внутри DeadlockBTest.last()");
    }
}