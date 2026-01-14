package ru.red.thread_test.synch_thread_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueueTest {
    private static final Logger log = LoggerFactory.getLogger(QueueTest.class);
    private int n;
    private boolean valueSet = false;

    synchronized int get() {
        while (!valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("Перехвачено исключение" + e.getMessage());
            }
        log.info("Получено: {}", n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while (valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("Перехвачено исключение" + e.getMessage());
            }
        this.n = n;
        valueSet = true;
        log.info("Отправлено: {}", n);
        notify();
    }
}
