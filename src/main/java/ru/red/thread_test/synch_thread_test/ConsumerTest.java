package ru.red.thread_test.synch_thread_test;

public class ConsumerTest implements Runnable {
    private QueueTest queueTest;
    private Thread thread;

    ConsumerTest(QueueTest queueTest) {
        this.queueTest = queueTest;
        thread = new Thread(this, "Потребитель");
    }
    @Override
    public void run() {
        while (true) {
            queueTest.get();
        }
    }

    public Thread getThread() {
        return thread;
    }
}
