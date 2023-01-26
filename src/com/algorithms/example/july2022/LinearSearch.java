package com.algorithms.example.july2022;

public class LinearSearch {
    public static void main(String args[]){
//        int n = 50;
//        int[] array = {10,20,30,40,50,60};
//        for(int i =0;i<array.length;i++){
//            if(array[i]==n){
//                System.out.println("ele found at index "+i);
//            }
//        }

        int searchArr[] = {10, 20 , 30, 40, 50};
        int key = linearSearch(60,searchArr);
        System.out.println("ele found at :"+key);
    }

    private static int linearSearch(int ele, int[] searchArr) {
        for (int i = 0; i < searchArr.length; i++) {
            if (searchArr[i] == ele) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int ele, int[] searchArr){
        return 1;
    }
}
