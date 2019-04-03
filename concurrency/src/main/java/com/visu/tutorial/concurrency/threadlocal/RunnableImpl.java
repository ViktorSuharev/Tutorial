package com.visu.tutorial.concurrency.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

public class RunnableImpl implements Runnable {

    private AtomicInteger counter = new AtomicInteger(0);

    private ThreadLocal<Integer> stats = ThreadLocal.withInitial(() -> 0);

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " here. Counter is " + counter.getAndIncrement());

        int processed = stats.get() + 1;
        stats.set(processed);
        if (processed > 2) {
            System.out.println(Thread.currentThread().getName() + " here. It was " + processed + " processed task. I tired");
        }

        try { Thread.currentThread().sleep(2000L); } catch (Exception e) {}
    }
}
