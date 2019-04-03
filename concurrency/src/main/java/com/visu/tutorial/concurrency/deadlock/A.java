package com.visu.tutorial.concurrency.deadlock;

public class A {

    private final String resource = "lockA";

    public void methodA (B b) {
        System.out.println(Thread.currentThread().getName() + " trying to acquire " + resource);
        try { Thread.sleep(100);} catch (Exception e) {}

        synchronized (resource) {
            System.out.println(Thread.currentThread().getName() + " acquired " + resource);
            b.methodB(this);
        }

        System.out.println(Thread.currentThread().getName() + " released " + resource);
    }
}
