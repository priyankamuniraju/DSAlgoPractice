package com.algorithms.example;

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
        int temp=0;
        for(int i =0;i<n-1;i++){
            int flag = 0;
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]= temp;
                    flag=1;
                }
            }
            if(flag==0){
                break;
            }
        }
        return arr;
    }
}
