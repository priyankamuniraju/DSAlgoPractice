package com.algorithms.example.Arrays2023;
/*
Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.
 */
public class SearchInsertPosition {
    public static void main(String args[]) {
        int[] inputArray = {1, 2, 3, 4, 5, 6, 8, 9, 10};
        int insertVal = 7;
        int postion = insertPosition(inputArray,insertVal);
        System.out.println("the position/insert position is "+postion);
    }

    public static int insertPosition(int[] array, int val) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > val) {
                return i+1;
            } else if (array[i] == val) {
                return i ;
            }
        }
        return 0;
    }
}
