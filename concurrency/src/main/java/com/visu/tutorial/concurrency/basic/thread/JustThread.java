package com.visu.tutorial.concurrency.basic.thread;

class JustThread extends Thread {
    public JustThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread " +  getName() + " here");
    }
}

