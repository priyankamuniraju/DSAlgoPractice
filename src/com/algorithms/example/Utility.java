package com.algorithms.example;

import java.util.Random;

public class Utility {
    public static int[] generateRandomArray(int size, int bound) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(bound);
            //System.out.print(" " + arr[i]);
        }
        return arr;
    }
}
