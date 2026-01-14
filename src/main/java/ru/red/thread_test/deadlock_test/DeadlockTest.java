package ru.red.thread_test.deadlock_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeadlockTest implements Runnable{
    private static final Logger log = LoggerFactory.getLogger(DeadlockTest.class);
    DeadlockATest deadlockATest = new DeadlockATest();
    DeadlockBTest deadlockBTest = new DeadlockBTest();
    Thread thread;

    DeadlockTest() {
        Thread.currentThread().setName("MainTread");
        thread = new Thread((Runnable) this, "RacingTread");
    }

    void deadlockStart() {
        thread.start();
        deadlockATest.foo(deadlockBTest);
        log.info("Назад в главный поток");
    }

    public void run() {
        deadlockBTest.bar(deadlockATest);
        log.info("Назад в другой поток");
    }

    public static void main(String[] args) {
        DeadlockTest deadlockTest = new DeadlockTest();
        deadlockTest.deadlockStart();
        //Выполнить условия
        log.info("Без блокировки потоков");
    }
}
