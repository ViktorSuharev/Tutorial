package com.visu.tutorial.concurrency.basic;

class JustRunnable implements Runnable {

    public void run() {
        int i = 0;
        Thread currentThread = Thread.currentThread();
        System.out.printf("[%s]: count is %3d%n", currentThread.getName(), i++);
        Thread.yield();
    }
}

class Main2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            Runnable justRunnable = new JustRunnable();
            Thread thread = new Thread(justRunnable, "Thread "+ i);
            thread.setPriority(i);
            thread.start();
        }

        int i = 0;
        Thread currentThread = Thread.currentThread();
        while (! currentThread.isInterrupted()) {
            System.out.printf("[main]: count is %3d%n", i++);
            Thread.yield();
        }
    }
}