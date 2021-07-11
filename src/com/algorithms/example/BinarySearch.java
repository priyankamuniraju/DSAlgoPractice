package com.algorithms.example;

public class BinarySearch {
    public static void main(String[] args){
        int[] array = {10,20,30,40,50};
        binarySearch(array,0,4,20);

    }
    public static void binarySearch(int[] arr,int first, int last,int key){
        int mid = (first+last)/2;
        while(first<=last){
            if(arr[mid]==key){
                System.out.println("the element is found at "+mid);
                break;
            }
            else if(key<arr[mid]){
                last = mid-1;
            }
            else if(key>arr[mid]){
                first = mid+1;
            }
            mid = (first+last)/2;
        }
        if ( first > last ){
            System.out.println("Element is not found!");
        }
    }
}
