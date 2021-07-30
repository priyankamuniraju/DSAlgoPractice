package com.algorithms.example.queue;

import com.algorithms.example.Utility;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class MaxOfAllSubArray {

    static int subArraySize = 10000;

    public static void main(String[] args) {
//        int[] array = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int[] array = Utility.generateRandomArray(1000000,20);
        //int[] array = {1,3,2,7,5,3,2,6,1,2};
        //int[] array = {3,3,3,3,5,3,2,6,1,2};

        //Priority Queue - to be implemented .. right now just copying array to Pqueue - O(n log k)
//        nanoStart = System.nanoTime();
//        System.out.println("Output = " + maxofSubarrayPriorityQueue(array, array.length, subArraySize));
//        nanoEnd = System.nanoTime();
//        System.out.println("Time taken by MaxOfAllSubArray - PriorityQueue method : " + (nanoEnd - nanoStart) / 1000);


        //Dequeue - O(n)
        long nanoStart = System.nanoTime();
//        System.out.println("Output = " +
                maxofSubarrayDequeue(array, array.length, subArraySize);
        long nanoEnd = System.nanoTime();
        System.out.println("Time taken by MaxOfAllSubArray - Dequeue method : " + (nanoEnd - nanoStart) / 1000);


        //brute force - O(nk)
        nanoStart = System.nanoTime();
        int[] arrayMax = maxofSubarrayBruteforce(array, array.length, subArraySize);
        nanoEnd = System.nanoTime();
//        for (int k = 0; k < arrayMax.length; k++) {
//            System.out.print(" " + arrayMax[k]);
//        }
        System.out.println();
        System.out.println("Time taken by MaxOfAllSubArray - Bruteforce method : " + (nanoEnd - nanoStart) / 1000);

    }

    public static int[] maxofSubarrayBruteforce(int[] arr, int n, int k) {
        int[] resultArray = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = arr[i];
            for (int j = i + 1; j < k + i; j++) {
                max = Math.max(max, arr[j]);
            }
            resultArray[i] = max;
        }
        return resultArray;
    }

    public static PriorityQueue<Integer> maxofSubarrayPriorityQueue(int[] arr, int n, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            priorityQueue.add(arr[i]);
        }
        return priorityQueue;
    }

    public static List<Integer> maxofSubarrayDequeue(int[] arr, int n, int k) {
        List<Integer> resultArray = new ArrayList<>();

        Deque<Integer> deque = new ConcurrentLinkedDeque<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && arr[i] >= arr[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for (int i = k; i < n; i++) {
            resultArray.add(arr[deque.getFirst()]);
            while (!deque.isEmpty() && (i - k) >= deque.getFirst()) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && arr[i] >= arr[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        resultArray.add(arr[deque.getFirst()]);

        return resultArray;
    }


}
