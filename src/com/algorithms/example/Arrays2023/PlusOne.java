package com.algorithms.example.Arrays2023;
/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order.
The large integer does not contain any leading 0's.
Increment the large integer by one and return the resulting array of digits.
 */
public class PlusOne {
    public static void main(String args[]){
        int[] inputArray1 = {1,9,9,9,9,9,9};
        int[] outputArray = plusOne(inputArray1);
        for(int j=0;j<=inputArray1.length-1;j++){
            System.out.print(inputArray1[j]+" ");
        }

    }

    private static int[] plusOne(int[] array){
        for(int i=array.length-1;i>0;i--){
            if(array[i]!=9){
                array[i] += +1;
                return array;
            }
            if(array[i]==9 && array[i-1]!=9){
                array[i] = 0;
                array[i-1] = array[i-1]+1;
                return array;
            }
            else if(array[i]==9 && array[i-1]==9){
                array[i]=0;
            }
        }
        return array;
    }
}
