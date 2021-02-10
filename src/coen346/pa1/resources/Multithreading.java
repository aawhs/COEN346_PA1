package coen346.pa1.resources;
import java.lang.Thread;
import java.lang.Runnable;

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
