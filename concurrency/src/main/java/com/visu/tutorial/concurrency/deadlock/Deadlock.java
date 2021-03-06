package com.visu.tutorial.concurrency.deadlock;

public class Deadlock {

    private static final A a = new A();
    private static final B b = new B();

    private static Thread t1 = new Thread(() -> a.methodA(b), "Thread-1");
    private static Thread t2 =  new Thread(() -> b.methodB(a), "Thread-2");

    public static void main(String[] args) {
        t1.start();
        t2.start();
    }
}