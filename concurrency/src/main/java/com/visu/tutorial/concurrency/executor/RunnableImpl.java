package com.visu.tutorial.concurrency.executor;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RunnableImpl implements Runnable {

    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private int counter = 0;

    public void increment() {
        try {
            while (true) {
                if (lock.writeLock().tryLock()) {
                    counter++;
                    break;
                }
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void run() {
        increment();
        System.out.println(Thread.currentThread().getName() + " here. Counter is " + getCounter());
    }

    public int getCounter() {
        try {
            if (lock.readLock().tryLock()) {
                return counter;
            }
        } finally {
            lock.readLock().unlock();
        }

        return -1;
    }
}
