package com.visu.tutorial.concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutorMain {

    public static void main(String[] args) {
        Runnable runnable = new RunnableImpl();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10000; ++i) {
            executor.submit(runnable);
        }


//        System.out.println("FINISH " + ((RunnableImpl) runnable).getCounter().get());
    }
}
