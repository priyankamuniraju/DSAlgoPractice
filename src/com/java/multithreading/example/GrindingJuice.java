package com.java.multithreading.example;

public class GrindingJuice implements Runnable{
    int count=0;
    @Override
    public void run() {
        System.out.println("I'm grinding juice ");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
