package com.task.planner;

import java.util.Random;

public class Utility {

    public final static String TAB = "\t";

    public static int[] generateRandomArray(int size, int bound) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(bound);
            //System.out.print(" " + arr[i]);
        }
        return arr;
    }

    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }
}
