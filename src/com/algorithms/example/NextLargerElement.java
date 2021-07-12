package com.algorithms.example;
import com.datastructures.example.ArrayStack;

import java.util.Random;

/**This is a function problem. You only need to complete the function nextLargerElement() that takes list of integers arr[ ]
and N as input parameters and returns list of integers of length N denoting the next greater elements for all the
corresponding elements in the input array.**/

public class NextLargerElement {

    public static int[] generateFixedArray() {
        return new int[] {8, 3, 5, 9, 2, 6, 1};
    }

    public static int[] generateRandomArray(int size, int bound) {
        Random random = new Random();
        int[] arr = new int[size];
        for(int i = 0; i< arr.length ;i++){
            arr[i]=random.nextInt(bound);
            System.out.print(" " + arr[i]);
        }

        return arr;
    }

    public static void main(String[] args){
        //int[] arr = generateFixedArray();
        int size = 15;
        int[] arr = generateRandomArray(size, 50);

        System.out.println();
        int [] returnArray;
        returnArray = nextLargerElement(arr,size);
        for (int j : returnArray) {
            System.out.print( " " + j);
        }

        int[] arr1 = new int[]{8, 3, 5, 9, 2, 6, 1};
        int[] resArr = nextLargerElementUsingStack(arr1,7);

        System.out.println();
        System.out.println("Next large element in O(n) is");
        for(int k : resArr){
            System.out.print(" "+k);
        }

    }

    public static int[] nextLargerElement(int[] array, int n){
        int [] newArray = new int[array.length];
        for(int i=0;i<n;i++){
            int ele = array[i];
            newArray[i]=-1;
            for(int j=i+1;j<n;j++){
                if(array[j] > ele){
                    newArray[i]=array[j];
                    break;
                }
            }
        }
       return newArray;
    }

    public static int[] nextLargerElementUsingStack(int[] array, int n){
        int size = n;
        int[] resultArr = new int[size];
        ArrayStack stack = new ArrayStack();
        stack.push(-1);
        stack.push(array[size-1]);
        resultArr[size-1]=-1 ;

        for(int i=size-2;i>=0;i--){
            int p = stack.peek();
            if(p==array[i]){
               //add later
            }
            else if(p>array[i]){
                resultArr[i]=p;
                stack.push(array[i]);
            }
            else {
                while(true){
                int p1 = stack.peek();
                if (p1 == -1) {
                    resultArr[i] = -1;
                    stack.push(array[i]);
                    break;
                } else if (p1 > array[i]) {
                    resultArr[i] = p1;
                    stack.push(array[i]);
                    break;
                } else if (p1 < array[i]) {
                    stack.pop();
                }
            }
            }
        }
        return resultArr;
    }
}

