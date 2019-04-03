package com.visu.tutorial.concurrency.basic.thread;

class Main {
    public static void main(String[] args) {
        Thread thread = new JustThread("Thread-1");
        thread.start();
    }
}
