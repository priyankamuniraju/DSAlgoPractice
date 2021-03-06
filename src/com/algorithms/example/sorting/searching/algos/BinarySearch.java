package com.algorithms.example.sorting.searching.algos;

public class BinarySearch {
    private static int[] arr;
    private static int first;
    private static int last;
    private static int key;

    public static void main(String[] args){
        int[] array = {10,20,30,40,50};
        binarySearch(array,0,4,60);

    }
    public static void binarySearch(int[] arr,int first, int last,int key){
        BinarySearch.arr = arr;
        BinarySearch.first = first;
        BinarySearch.last = last;
        BinarySearch.key = key;
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
