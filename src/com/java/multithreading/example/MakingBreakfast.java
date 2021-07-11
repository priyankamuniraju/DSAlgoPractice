package com.java.multithreading.example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MakingBreakfast implements Runnable{
    Lock mylock = new ReentrantLock();
    @Override
    public void run() {
        //System.out.println("Waiting for previous task of making breakfast");
        mylock.lock();
        System.out.println("I'm making bf ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mylock.unlock();
    }
}
