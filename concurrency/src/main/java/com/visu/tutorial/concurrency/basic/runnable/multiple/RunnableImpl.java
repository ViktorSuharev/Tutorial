package com.visu.tutorial.concurrency.basic.runnable.multiple;

import java.util.concurrent.atomic.AtomicInteger;

public class RunnableImpl implements Runnable {

    private AtomicInteger counter = new AtomicInteger(0);

    public void run() {
        System.out.println(Thread.currentThread().getName() + " here. Counter is " + counter.getAndIncrement());
    }
}
