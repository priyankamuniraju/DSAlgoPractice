package com.algorithms.example.july2022;

public class BinarySearch {
    public static void main(String args[]){
        int[] array = {100,200,300,400,500,600};
        binarysearch(array,100,0,array.length-1);
    }

    public static void binarysearch(int[] arr, int ele, int first , int last){
        int mid = (first+last)/2;
        if(arr[mid]==ele){
            System.out.println("Ele found at index "+mid);
        }
        else if(arr[mid]>ele){
            first = 0;
            last = mid-1;
            binarysearch(arr,ele,first,last);
        }
        else {
            first = mid+1;
            last = arr.length-1;
            binarysearch(arr, ele, first, last);
        }
    }
}
