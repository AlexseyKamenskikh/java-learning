package ru.red.thread_test.synch_thread_test;

public class PCTest {
    public static void main(String[] args) {
        QueueTest queueTest = new QueueTest();
        ProducerTest producerTest = new ProducerTest(queueTest);
        ConsumerTest consumerTest = new ConsumerTest(queueTest);

        //Запустить потоки
        producerTest.getThread().start();
        consumerTest.getThread().start();
    }
}
