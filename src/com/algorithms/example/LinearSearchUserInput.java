package com.algorithms.example;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class LinearSearchUserInput {
    public static void main(String[] args){
        System.out.println("Enter the number of elements in the array or the array size.");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("Enter the array elements.");
        int[] array = new int[n];
        for(int i =0;i<n;i++){
            array[i]=in.nextInt();
        }
        System.out.println("Enter the search element.");
        int key = in.nextInt();
        int index  = linearSearch(array,n, key);
        System.out.println("Key found at position "+index);
    }
    public static int  linearSearch(int arr[],int n, int key){
        for(int i =0;i<n;i++){
            if(arr[i]==key){
                return i+1;
            }
        }
        return -1;
    }

}
