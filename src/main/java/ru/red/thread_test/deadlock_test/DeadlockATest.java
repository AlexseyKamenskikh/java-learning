package ru.red.thread_test.deadlock_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeadlockATest {
    private static final Logger log = LoggerFactory.getLogger(DeadlockATest.class);

    synchronized void foo(DeadlockBTest bTest) {
        String name = Thread.currentThread().getName();
        log.info("{} вошел в DeadlockATest.foo", name);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Поток превран: {}", e.getMessage());
        }
        log.info(" {} пытается вызвать DeadlockBTest.last()", name);
        bTest.last();
    }

    //Убрать synchronized чтоб исключить взаимоблокировку
    synchronized void last() {
        log.info("Внутри DeadlockATest.last()");
    }
}
