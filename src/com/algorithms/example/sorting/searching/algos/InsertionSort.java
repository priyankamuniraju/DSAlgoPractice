package com.algorithms.example.sorting.searching.algos;

public class InsertionSort {
    public static void main(String[] args){
        int[] arr = {40,50,20,10,30};
        insertionSort(arr);

        for(int k =0 ; k< arr.length;k++){
            System.out.print(" "+arr[k]);
        }
    }
    public static int[] insertionSort(int[] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }
}
