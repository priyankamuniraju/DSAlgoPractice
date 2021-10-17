package com.algorithms.example.sorting.searching.algos;

public class BubbleSort {
    public static void main(String[] args){
        int[] arr={50,20,30,100,75,68,55,80};
        int[] sortedArray = bubbleSort(arr);
        for(int k=0;k<sortedArray.length;k++){
            System.out.print(sortedArray[k]+" ");
        }
    }
    public static int[] bubbleSort(int[] arr){
        int n = arr.length;
        for(int i =0;i<n-1;i++){
            int flag = 0;
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]= temp;
                    flag=1;
                }
            }
            //if no swapping is done in a pass break from the outer for loop because this means the array is now sorted.
            if(flag==0){
                break;
            }
        }
        return arr;
    }
}
