package com.algorithms.example.sorting.searching.algos;

public class SelectionSort {
    public static void main(String[] args){
//        int[] arr = {10,20,30,40,50,60};
        int[] arr = {70,10,30,40,50,20};
//        int[] arr = {70,60,50,40,30,20,10};
//        int[] arr = {15,28,17,12,18,9,6};
        selectionSort(arr);
        for(int k=0;k<arr.length;k++){
            System.out.print(" "+arr[k]);
        }
    }

    public static void selectionSort(int[] array){
        int n = array.length;
        for(int i=0;i<n-1;i++) {
            int min = i;
            for (int j = (i+1); j < n; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
                if (min != i) {
                    int temp = array[min];
                    array[min] = array[i];
                    array[i] = temp;
                }

        }
    }


}
