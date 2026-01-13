package ru.red.thread_test.synch;

public class Caller implements Runnable {
    private final String msg;
    private final CallMe  target;
    private final Thread thread;

    public Caller(CallMe target, String msg) {
        this.target = target;
        this.msg = msg;
        this.thread = new Thread(this);
    }

    @Override
    public void run() {
        target.call(msg);
    }

    public Thread getThread() {
        return thread;
    }
}
