package com.algorithms.example.Arrays2023;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 */
public class TwoSum {
    public static void main(String args[]){
        int[] array = {3,6 ,20,2,17};
        int target = 9;
        twoSum(array,target);

    }

   static void twoSum(int[] nums , int target) {
       for (int i = 0; i < nums.length; i++) {
           for (int j = i + 1; j < nums.length; j++) {
               if ((nums[i]+nums[j]) == target) {
                   System.out.println("the indices are :"+" "+ i +" "+j);
               }
           }
       }
   }
}
