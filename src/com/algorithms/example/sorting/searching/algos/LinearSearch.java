package com.algorithms.example.sorting.searching.algos;

public class LinearSearch {
    public static void main(String[] args) {
        int array[] = {10, 20, 30, 40, 50};
        int key = 40;
        System.out.println("Key at found at " + linearSearch(array,key));
    }

    public static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (key == array[i]) {
                return i;
            }
        }
        return -1;
    }
}