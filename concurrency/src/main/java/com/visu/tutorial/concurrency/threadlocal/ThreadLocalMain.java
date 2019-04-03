package com.visu.tutorial.concurrency.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalMain {
    public static void main(String[] args) {
        Runnable runnable = new RunnableImpl();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(runnable);
        executor.submit(runnable);
        executor.submit(runnable);
        executor.submit(runnable);
        executor.submit(runnable);
        executor.submit(runnable);
        executor.submit(runnable);
        executor.submit(runnable);
    }
}
