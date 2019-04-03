package com.visu.tutorial.concurrency.basic.runnable;

class JustRunnableMain {
    public static void main(String[] args) {
        Runnable justRunnable = new JustRunnable();
        Thread thread = new Thread(justRunnable, "Thread-1");
        thread.start();
    }
}
