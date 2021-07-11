package com.java.multithreading.example;

public class BoilingMilk implements Runnable {
    int count = 0;
    @Override
    public void run() {
        System.out.println("I'm boiling milk " );
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
