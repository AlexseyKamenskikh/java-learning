package ru.red.thread_test.suspend_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SuspendResume {
    private static final Logger log = LoggerFactory.getLogger(SuspendResume.class);

    public static void main(String[] args) {
        NewThread newThread1 = new NewThread("One");
        NewThread newThread2 = new NewThread("Two");

        newThread1.getThread().start();
        newThread2.getThread().start();

        try {
            Thread.sleep(1000);
            newThread1.mySuspend();
            log.info("Приостановка потока {}", newThread1.getThread().getName());
            Thread.sleep(1000);
            newThread1.myResume();
            log.info("Возобновление потока {}", newThread1.getThread().getName());

            newThread2.mySuspend();
            log.info("Приостановка потока {}", newThread2.getThread().getName());
            Thread.sleep(1000);
            newThread2.myResume();
            log.info("Возобновление потока {}", newThread2.getThread().getName());
        } catch (InterruptedException e) {
            log.error("Главный поток прерван");
        }

        //Ожидать завершения потоков.
        try {
            log.info("Ожидание завершения потоков");
            newThread1.getThread().join();
            newThread2.getThread().join();
        } catch (InterruptedException e) {
            log.error("Главный поток прерван");
        }
        log.info("Главный поток завершается");
    }
}
