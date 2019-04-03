package com.visu.tutorial.concurrency.executor;

import java.util.concurrent.atomic.AtomicInteger;

public class RunnableImpl implements Runnable {

    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " here. Counter is " + counter.getAndIncrement());

        try { Thread.currentThread().sleep(2000L); } catch (Exception e) {}
    }
}
