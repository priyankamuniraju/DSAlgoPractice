package com.algorithms.example.stack;

import com.algorithms.example.Utility;
import com.datastructures.example.ArrayStack;

import java.util.Random;
import java.util.Stack;

/**
 * This is a function problem. You only need to complete the function nextLargerElement() that takes list of integers arr[ ]
 * and N as input parameters and returns list of integers of length N denoting the next greater elements for all the
 * corresponding elements in the input array.
 **/

public class NextLargerElement {

    public static int[] generateFixedArray() {
        return new int[]{8, 3, 5, 9, 2, 6, 1};
    }

    public static void main(String[] args) {
        //int[] arr = generateFixedArray();
        int size = 10000000;
        int[] arr = Utility.generateRandomArray(size, 10000);

        System.out.println();
        int[] returnArray;

        long nanoStart = System.nanoTime();
        returnArray = nextLargerElement(arr, size);
        long nanoEnd = System.nanoTime();

//        for (int j : returnArray) {
//            System.out.print(" " + j);
//        }

        System.out.println();
        System.out.println("Time taken by nextLargerElement = " + (nanoEnd - nanoStart)/1000);

        Stack<Integer> stack = new Stack<>();
        nanoStart = System.nanoTime();
        int[] resArr = nextLargerElementUsingStack(arr, size, stack);
        nanoEnd = System.nanoTime();

//        System.out.println();
//        System.out.println("Next large element in O(n) is");
//        for (int k : resArr) {
//            System.out.print(" " + k);
//        }
        System.out.println();
        System.out.println("Tim taken by nextLargerElementUsingStack = " + (nanoEnd - nanoStart)/1000);

    }

    public static int[] nextLargerElement(int[] array, int n) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < n; i++) {
            int ele = array[i];
            newArray[i] = -1;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > ele) {
                    newArray[i] = array[j];
                    break;
                }
            }
        }
        return newArray;
    }

    public static int[] nextLargerElementUsingStack(int[] array, int size, Stack<Integer> stack) {
        int[] resultArr = new int[size];

        stack.push(-1);
        for (int i = size - 1; i >= 0; i--) {
            int currElem = array[i];
            while (true) {
                int peek = stack.peek();
                if (peek == -1 || peek >= currElem) {
                    resultArr[i] = peek;
                    stack.push(currElem);
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        return resultArr;
    }
}

