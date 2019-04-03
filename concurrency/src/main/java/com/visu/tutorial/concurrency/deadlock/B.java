package com.visu.tutorial.concurrency.deadlock;

public class B {

    private final String resource = "lockB";

    public void methodB (A a) {
        System.out.println(Thread.currentThread().getName() + " trying to acquire " + resource);
        try { Thread.sleep(100);} catch (Exception e) {}

        synchronized (resource) {
            System.out.println(Thread.currentThread().getName() + " acquired " + resource);
            a.methodA(this);
        }

        System.out.println(Thread.currentThread().getName() + " released " + resource);
    }
}
