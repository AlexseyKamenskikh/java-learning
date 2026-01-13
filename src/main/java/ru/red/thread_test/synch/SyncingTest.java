package ru.red.thread_test.synch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SyncingTest {
    private static final Logger log = LoggerFactory.getLogger(SyncingTest.class);

    public static void main(String[] args) {
        CallMe target = new CallMe();
        Caller caller1 = new Caller(target, "Hello");
        Caller caller2 = new Caller(target, "Synchronized");
        Caller caller3 = new Caller(target, "World");

        //Запустить потоки
        caller1.getThread().start();
        caller2.getThread().start();
        caller3.getThread().start();

        //Ожидать окончания работы потоков
        try {
            caller1.getThread().join();
            caller2.getThread().join();
            caller3.getThread().join();
        } catch (InterruptedException e) {
            log.error("Прерван: {}", e.getMessage());
        }
    }
}
