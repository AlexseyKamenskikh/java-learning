package ru.red.thread_test.synch_thread_test;

public class ProducerTest implements Runnable {
    private QueueTest queueTest;
    private Thread thread;

    ProducerTest(QueueTest queueTest) {
        this.queueTest = queueTest;
        thread = new Thread(this, "Производитель");
    }
    @Override
    public void run() {
        int i = 0;
        while (true) {
            queueTest.put(i++);
        }
    }

    public Thread getThread() {
        return thread;
    }
}
