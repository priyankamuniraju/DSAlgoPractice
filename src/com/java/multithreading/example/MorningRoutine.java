package com.java.multithreading.example;

import java.util.ArrayList;
import java.util.List;

public class MorningRoutine {
    public static void main(String[] args) throws InterruptedException {

        //starting the task1 : boiling milk
        Thread bmThread = new Thread(new BoilingMilk());
        bmThread.start();

        //starting the task2 : making bf
        List<Thread> mblist = new ArrayList<>();
        Runnable mkr = new MakingBreakfast();
        for(int i = 0; i < 3; i++){
            Thread mbThread = new Thread(mkr);
            mbThread.start();
            mblist.add(mbThread);
        }

        //starting the task3 : grinding juice
        Thread gjThread = new Thread(new GrindingJuice());
        gjThread.start();

        //joining task1 : boiling milk
        bmThread.join();

        //joining task2 : making bf
        for (Thread mf : mblist) {
            mf.join();
        }

        //joining task3 : grinding juice
        gjThread.join();
        System.out.println("My morning routine is done!");
    }
}
