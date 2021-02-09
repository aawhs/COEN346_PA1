package coen346.pa1.resources;

public class Multithreading implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getId() + " started");
        //tList.add(Thread.currentThread());
    }

    public static void join() {
        System.out.println("Thread " + Thread.currentThread().getId() + " finished");
    }
}
