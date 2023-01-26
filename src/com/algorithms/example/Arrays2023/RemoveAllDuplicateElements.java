package com.algorithms.example.Arrays2023;

public class RemoveAllDuplicateElements {
    public static void main(String args[]){
        int[] array = {0,0,1,1,1,2,2,3,3,4};
        int[] returnArray = removeDuplicates(array);
        for(int i =0;i<returnArray.length;i++){
            System.out.print(" " +returnArray[i]);
        }
    }

    private static int[] removeDuplicates(int[] arr){
        for(int i=0; i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<=arr[i]){
                    continue;
                }
                else if(arr[j]>arr[i]){
                    i = i+1;
                    arr[i]=arr[j];
                    arr[j]= -1;
                }
            }
        }
        return arr;
    }
}
