package com.visu.tutorial.concurrency.basic;

class JustThread extends Thread {
    public JustThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.printf("Thread [%s] here %n", getName());
//        yield();
        System.out.printf("Thread [%s] here %n", getName());
    }
}

class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            Thread thread = new JustThread("Thread "+ i);
            thread.start();
        }
    }
}