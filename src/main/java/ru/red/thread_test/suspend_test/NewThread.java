package ru.red.thread_test.suspend_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewThread implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(NewThread.class);
    private String name;

    public Thread thread;
    private boolean suspendFlag;

    NewThread(String threadName) {
        this.name = threadName;
        thread = new Thread(this, threadName);
        suspendFlag = false;
        log.info("Новый поток: {}", thread);
    }

    @Override
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                log.info("{}: {}", name, i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            log.error("{} прерван", name);
        }
        log.info("{} завершается", name);
    }

    synchronized void mySuspend() {
        suspendFlag = true;
    }

    synchronized void myResume() {
        suspendFlag = false;
        notify();
    }

    public Thread getThread() {
        return thread;
    }
}
