package com.visu.tutorial.concurrency.basic.runnable.multiple;

public class MultipleThreadMain {

    public static void main(String[] args) {
        Runnable justRunnable = new RunnableImpl();
        Thread t1 = new Thread(justRunnable, "Thread-1");
        Thread t2 = new Thread(justRunnable, "Thread-2");
        t1.start();
        t2.start();
    }
}
